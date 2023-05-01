#Data section
.data
welcome: .asciiz "Let's play dots and boxes, pick two vertically/horizontally\nadjacent lines to connect. You will start first:\n"

.text

.globl exit
main:
   
   # Print welcome message
   li $v0, 4
   la $a0, welcome
   syscall
   li $s3, 100
   
   # Displays empty board
   jal createBoard
   
   jal checkBox
   # Rounds for each turn
   loop:
   	jal user_input
   	beq $v0, $0, exit
	jal computerstuff
  
      
      sub $s3,$s3,1
     
     beqz $s3, exit
      j loop
  jal createBoard
    
      
exit:
   li $v0, 10
   syscall
