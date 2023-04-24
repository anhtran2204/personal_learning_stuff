# Data section
.data
prompt: .asciiz "Please enter the coordinate string where you want to draw the line (e.g. A1E4): "
buffer: .space 5
pipe: .asciiz "|"
under: .asciiz "_"
n: .asciiz "\n"

# Text section
.text
.globl user_input

user_input:
    # Prompt the user to enter a string with 4 characters
    li $v0, 4           # system call for printing a string
    la $a0, prompt      # load the address of the prompt string
    syscall             # print the prompt

    # Read the user input into a buffer
    li $v0, 8           
    la $a0, buffer      
    li $a1, 5           
    syscall
    
    li $v0, 4
    la $a0, n
    syscall
    
    # Save any previous register values onto stack for later use
    sw $t2, 8($sp)  
    sw $t3, 12($sp)  
    sw $t4, 16($sp)  
    sw $t5, 20($sp)           
    sw $t6, 24($sp)           

    # Translate each letter to its corresponding number
    lb $t2, buffer($s0)      # load the first character into $t0
    addi $s0, $s0, 1
    lb $t3, buffer($s0)      # load the second character into $t1
    addi $s0, $s0, 1
    lb $t4, buffer($s0)      # load the third character into $t2
    addi $s0, $s0, 1
    lb $t5, buffer($s0)      # load the fourth character into $t3

    sub $t2, $t2, 65    # subtract 65 from the ASCII code of the first letter (A = 65)
    sub $t4, $t4, 65    
    sub $t3, $t3, 49    # subtract 48 from the ASCII code of the second number (1 = 49)
    sub $t5, $t5, 49    
    
    #Translate into the index of the 2d Array
    add $t2, $t2, $t2
    add $t3, $t3, $t3
    add $t4, $t4, $t4
    add $t5, $t5, $t5
    
    beq $t2, $t4, horizontal
    beq $t3, $t5, vertical
    
    j next
    

horizontal:
    move $t0, $t2
    blt $t3, $t5, horizontal_top # is the line below or above the second coordinate
    addi $t1, $t3, -1   # column where the line would be drawn
    
    move $a0, $t0
    move $a1, $t1
    lb $a2, under
    jal createBoard
    j next

horizontal_top:
    addi $t1, $t5, -1  	# column where the line would be drawn
      
    move $a0, $t0
    move $a1, $t1
    lb $a2, under
    jal createBoard
    j next
    
vertical:
    move $t1, $t3
    blt $t2, $t4, vertical_down
    addi $t0, $t2, -1  # row where the line would be drawn
    
    move $a0, $t0
    move $a1, $t1
    lb $a2, pipe
    jal createBoard
    j next
vertical_down:
    addi $t0, $t4, -1  # row where the line would be drawn
    
    move $a0, $t0
    move $a1, $t1
    lb $a2, pipe
    jal createBoard
    j next
    
next:
    
    # Exit the program
    li $v0 10
    syscall
