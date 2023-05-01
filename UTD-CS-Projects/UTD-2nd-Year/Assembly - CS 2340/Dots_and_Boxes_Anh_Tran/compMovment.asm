.data
   brd: .asciiz ".", " ", "."
   	  .asciiz "|" , " " , " "
   	  .asciiz "." , "-", "."	  
   	  #ignore ^
   rows: .word 13
   colm: .word  17
   .eqv DATA_SIZE 8
   pipe:     .asciiz "|"
   under:    .asciiz "_"
   emptySpace: .byte ' '
   test: .asciiz "YO HELLLLOOOO"
   argstor:  .word 0
   boxcget: .asciiz "The computer has gotten a box! Oh no!\n"
   pitch: .byte 69 #sound
duration: .byte 100
instrument: .byte 58
volume: .byte 100
  #.include "board.asm" 	  


.text
.globl computerstuff
	#read in game board, check for an empty space and error check it, if possible make a move.
computerstuff:	
	li $t9,1 #indicate current turn is computer
	#store registers
   	#addi $sp, $sp, -20
   	#sw $t0, 16($sp)
   	#sw $t1, 12($sp)
   	#sw $t3, 8($sp)
   	#sw $t5, 4($sp)
   	#sw $t6, 0($sp)
   move $s7, $ra
   tryagain:
   	######
	la $s1, board
	lw $s5, rows
	lw $s6, colm
	li $t3, 0
	
	li $t0, 0 # current row index
	li $t1, 0 # current colm index
	
	
	readLoop:

    
	
	
	#checks if empty maybe
        #***************call valid move(error), -> (#a3, also)
        jal validInput
        beq $a3, $zero,move1 
      
        
        
	
	j incrm
	
	
     	move1:
     		
             li $t9, 1  #let other files know it is computer turn
             li $t5, 2

             div $t0,$t5       #check if odd number to see which line is needed
             mfhi $s1
	    
	   
	     jal checkBox
	     sw $a3,argstor
	     
            move $a1, $t0
           
            move $a2, $t1
            
            beqz $s1, horz #if even horz line, if odd keep going.

             vert:
 
             lb $a3, pipe
            jal createBoard
            j next

             horz:
             lb $a3, under
            jal createBoard

            next:
          
             lw $a3,argstor
             beq $a3, 1, box_get
      
       
        j Done
        
	#condition increm
    	incrm:
    
    	addi $t1, $t1, 1
   	slt $t5, $t1, $s6
    	beq $t5, 0, norm
    	j readLoop
    	
    	norm:

    	addi $t0,$t0,1
    	
        slt $t5, $t0, $s5
    
        li $t1, 0 
    	beq $t5, 1, readLoop
    	
        
    	
     	Done:
   
   	######
   	#lw $t6, 0($sp)
	#lw $t5, 4($sp)
	#lw $t3, 8($sp)
	#lw $t1, 12($sp)
	#lw $t0, 16($sp)
	#addi $sp, $sp, 20
	move $ra, $s7

	jr $ra
        
        box_get:
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
  	  la $a0, boxcget
   	 syscall
	
	j tryagain
