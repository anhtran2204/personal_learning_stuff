# Data section
.data
prompt:   .asciiz "Enter the coordinate string of the dots, where you want to draw the line (e.g. A1E4) (Enter '0000' to exit the game.): "
tryagain: .asciiz "Please try again.\n"
error_rng:.asciiz "Not in range.\nPlease try again.\n"
error_adj:.asciiz "Line cannot be drawn between given dots.\nPlease try again.\n"
win:	  .asciiz "Good job. You've beat the computer!"
boxget:	  .asciiz "You got a box! Nice!\n"
inin:     .asciiz "Please only use 4 characters, try again."
pipe:     .asciiz "|"
under:    .asciiz "_"
space:    .asciiz " "
n:        .asciiz "\n"
buffer:   .space 16
exitInput:.byte '0'
return_ad:.word 0
argstor:  .word 0
pitch: .byte 69 #sound
duration: .byte 100
instrument: .byte 58
volume: .byte 100


# Text section
.text
.globl user_input

user_input:

    sw $ra, return_ad
    
try_again:
    # Clear all registers
    li $t0, 0
    li $t1, 0
    li $t2, 0
    li $t3, 0
    li $t4, 0
    li $t5, 0
    li $t6, 0
    li $t9, 0
    li $a0, 0
    li $a1, 0
    li $a3, 0
    li $s0, 0
    li $s4, 0
    li $s6, 0
    
    # Prompt the user to enter a string with 4 characters
    li $v0, 4           # system call for printing a string
    la $a0, prompt      # load the address of the prompt string
    syscall             # print the prompt

    # Read the user input into a buffer
    li $v0, 8           
    la $a0, buffer      
    li $a1, 15           
    syscall
    
    
    
    li $v0, 4
    la $a0, n
    syscall
    

    # Translate each letter to its corresponding number
    lb $t2, buffer($s0)      # load the first character into $t2
    addi $s0, $s0, 1
    lb $t3, buffer($s0)      # load the second character into $t3
    addi $s0, $s0, 1
    lb $t4, buffer($s0)      # load the third character into $t4
    addi $s0, $s0, 1
    lb $t5, buffer($s0)      # load the fourth character into $t5

    lb $a0, exitInput($0)
    bne $t2, $a0, continue
    bne $t3, $a0, continue
    bne $t4, $a0, continue
    bne $t5, $a0, continue
    li $v0, 0
    j exit

    continue:
    sub $t2, $t2, 65    # subtract 65 from the ASCII code of the first letter (A = 65)
    sub $t4, $t4, 65    
    sub $t3, $t3, 49    # subtract 48 from the ASCII code of the second number (1 = 49)
    sub $t5, $t5, 49
    
    # Check to make sure input is in range ( A-G for rows. 1-9 for  columns.) 
    blt $t2, 0, not_in_range
    bgt $t2, 6, not_in_range
    blt $t3, 0, not_in_range
    bgt $t3, 8, not_in_range
    blt $t4, 0, not_in_range
    bgt $t4, 6, not_in_range
    blt $t5, 0, not_in_range
    bgt $t5, 8, not_in_range
    
    #Translate into the index of the 2d Array
    add $t2, $t2, $t2
    add $t3, $t3, $t3
    add $t4, $t4, $t4
    add $t5, $t5, $t5
    
    
    # Check for whtether line is vertical or horizontal
    beq $t2, $t4, horizontal  # If row coordinates are the same, the line must be horizontal
    beq $t3, $t5, vertical    # If column coordinates are the same, the line must be vertical
    
    j not_adjacent	      # If neither the row or columns match, they must not be adjacent
    
horizontal:
    move $t0, $t2
    blt $t3, $t5, horizontal_top # is the line below or above the second coordinate
    addi $t1, $t3, -1   	 # column where the line would be drawn
    
    # Checks to see if the index is adjacent
    sub $t6, $t3, $t5
    bne $t6, 2, not_adjacent
    
    jal validInput
    beq $a3, 1, error
    jal checkBox
    
    sw $a3, argstor
    
    # Saves column index, row index, and character to save and calls on interface to create a board. 
    move $a1, $t0
    move $a2, $t1
    lb $a3, under
    jal createBoard
    
    lw $a3, argstor
    beq $a3, 1, box_comp
    
    j next

horizontal_top:
    addi $t1, $t5, -1  	# column where the line would be drawn
    
    # Checks to see if the index is adjacent
    sub $t6, $t5, $t3
    bne $t6, 2, not_adjacent
    
    jal validInput
    beq $a3, 1, error
    jal checkBox
    
    sw $a3, argstor
    
    # Saves column index, row index, and character to save and calls on interface to create a board. 
    move $a1, $t0
    move $a2, $t1
    lb $a3, under
    jal createBoard
    
    lw $a3, argstor
    beq $a3, 1, box_comp
    
    j next
    
vertical:
    move $t1, $t3
    blt $t2, $t4, vertical_down
    addi $t0, $t2, -1  # row where the line would be drawn
    
    # Checks to see if the index is adjacent
    sub $t6, $t2, $t4
    bne $t6, 2, not_adjacent
    
    jal validInput
    beq $a3, 1, error
    jal checkBox
    
    sw $a3, argstor
    
    # Saves column index, row index, and character to save and calls on interface to create a board. 
    move $a1, $t0
    move $a2, $t1
    lb $a3, pipe
    jal createBoard
    
    lw $a3, argstor
    beq $a3, 1, box_comp
    
    j next

vertical_down:
    addi $t0, $t4, -1  # row where the line would be drawn
    
    # Checks to see if the index is adjacent
    sub $t6, $t4, $t2
    bne $t6, 2, not_adjacent
    
    jal validInput
    beq $a3, 1, error
    
    jal checkBox
    
    sw $a3, argstor
    
    # Saves column index, row index, and character to save and calls on interface to create a board. 
    move $a1, $t0
    move $a2, $t1
    lb $a3, pipe
    jal createBoard
    
    lw $a3, argstor
    beq $a3, 1, box_comp
    
    j next

# Print error message and restart turn
not_adjacent:
    li $v0, 4
    la $a0, error_adj
    syscall
    
    j try_again

# Print error message and restart turn
not_in_range:
    li $v0, 4
    la $a0, error_rng
    syscall
    
    j try_again

# Print incorrect input message    
incorrectinput:
    li $v0, 4
    la $a0, inin
    syscall
    
    j try_again
    
    
# Print error message and restart turn
error: 
    li $v0, 4
    la $a0, tryagain
    syscall
    
    j try_again

#Checks if box has been made  
next:

    jal checkCompletion
    beq $t8, 2, win_exit
    
    lw $ra, return_ad
    jr $ra
    
box_comp:
    li     $v0, 31 
    la     $t0, pitch
    la     $t1, duration 
    la     $t2, instrument
    la     $t3, volume 
    move $a0, $t0 
    move    $a1, $t1 
    move    $a2, $t2
    move    $a3, $t3 
    syscall
    
    li $v0, 4
    la $a0, boxget
    syscall
    
    j try_again
win_exit:
   li $v0, 4
   la $a0, win
   syscall
   
   jal exit
    
# Exit the program
exit:
   lw $ra, return_ad
   jr $ra
