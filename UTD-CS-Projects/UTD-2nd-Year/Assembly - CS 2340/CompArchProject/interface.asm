	.data
colLabel:	.asciiz "A", "B", "C", "D", "E", "F", "G"
rowLabel:	.asciiz 1, 2, 3, 4, 5, 6, 7, 8, 9
board:	
	#.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	#.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " "
	#.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	#.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " "
	#.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	#.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " "
	#.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	#.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " "
	#.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	#.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " "
	#.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	#.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " "
	#.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	
	.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	.asciiz ".", ".", ".", ".", ".", ".", ".", ".", "."
	
boardSize:	.word	63
newline:	.asciiz "\n"
space:		.asciiz " "
lineAcross:	.asciiz	"_"
lineDown:	.asciiz "|"
			
	.text
.globl printBoard
printBoard:
	li $v0, 1
	la $a0, newLine
	syscall
	
	
