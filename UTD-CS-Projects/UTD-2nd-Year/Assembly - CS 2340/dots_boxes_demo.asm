	.data
board:	
		.byte	'.', ' ', '.', ' ', '.'
		.byte ' ', ' ', ' ', ' ', ' '
		.byte	'.', ' ', '.', ' ', '.'
		.byte ' ', ' ', ' ', ' ', ' '
		.byte	'.', ' ', '.', ' ', '.'
		
rowLabel:		.byte 'A', 'B', 'C'
colLabel: 		.word 1, 2, 3
rowSize:		.word 5
colSize:		.word 5
totalSize:		.word 25
newLine:		.byte '\n'
space:		.byte ' '
horiLine:		.byte '_'
vertLine:		.byte '|'
dots:			.byte '.'

msg1:		.asciiz "Enter coordinates to connect > "
error1:		.asciiz "Line already exists!\n"
error2:		.asciiz "Coordinates must be adjacent!\n"
input: 		.space 16
row1:		.space 4
col1: 		.space 4
row2:		.space 4
col2:			.space 4

	.text
main:
	jal createBoard
	
	#jal askInput
	
	j exit
	
askInput:
	
	
createBoard:
	lw $t0, rowSize
	lw $t1, colSize
	#lw $s0, ($a0)
	#lw $s1, ($a1)
	
	li $t2, 0
	li $t3,0
	outer:
		bge $t2, $t0, endOuter
		li $t4, 0
		inner:
			bge $t4, $t1, endInner
			lb $a0, board($t3)
			li $v0, 11
			syscall
			addi $t2, $t2, 1
			addi $t3, $t3, 1
			
			j inner
		endInner:
			addi $t2, $t2, 1
			li $v0, 11
			lb $a0, newLine
			syscall
			
			j outer
	endOuter:
		li $v0, 11
		lb $a0, newLine
		syscall
		jr $ra

findIndex:
	lw $t0, rowSize
	lw $t1, colSize
	#lw $s0, ($a0)
	#lw $s1, ($a1)
	
	li $t2, 0
	li $t3, 0
	findRow:
		bge $t2, $t0, findCol
		lb $t4, rowLabel($t3)
		bne $t4, $s0, else
			sb $t4, ($v0)
			addi $t2, $t2, 2
			addi $t3, $t3, 1
			j findRow
		
		else:
			j findRow	
		
	li $t2, 0
	li $t3, 0
	findCol:
	

exit:
	li $v0, 10
	syscall
