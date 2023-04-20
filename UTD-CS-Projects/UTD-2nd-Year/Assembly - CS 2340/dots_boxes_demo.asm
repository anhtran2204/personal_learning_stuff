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
	#jal createBoard
	
	jal askInput
	
	j exit
	
addSpace:
	sw $ra, ($sp)
	lb $a0, space($0)
	li $v0, 11
	syscall
	lw $ra, ($sp)
	jr $ra

addNewLine:
	sw $ra, ($sp)
	lb $a0, newLine($0)
	li $v0, 11
	syscall
	lw $ra, ($sp)
	jr $ra
	
askInput:
	li $v0, 4
	la $a0, msg1
	syscall

	li $v0, 8
	la $a0, input
	li $a1, 4
	syscall
	
	jal addNewLine
	
	li $t0, 0
	
	lb $a0, input($t0)
	li $v0, 11
	syscall
	sb $a0, row1	
	addi $t0, $t0, 1
	
	jal addNewLine
		
	lb $a0, input($t0)
	li $v0, 11
	syscall
	addi $a0, $a0, -48
	sb $a0, col1
	addi $t0, $t0, 1
	
	jal addNewLine
	
	lb $a0, input($t0)
	li $v0, 11
	syscall
	sb $a0, row2
	addi $t0, $t0, 1

	jal addNewLine
		
	lb $a0, input($t0)
	li $v0, 11
	syscall
	addi $a0, $a0, -48
	sb $a0, col2	
	
createBoard:
	sw $ra, ($sp)
	lw $t0, rowSize
	lw $t1, colSize
	
	jal findIndex
	
	li $t2, 0
	li $t3, 0
	outer:
		li $t4, 0
		inner:
			lb $a0, board($t3)
			li $v0, 11
			syscall
			addi $t4, $t4, 1
			addi $t3, $t3, 1
			
			ble  $t4, $t1, inner
		endInner:
			addi $t2, $t2, 1
			lb $a0, newLine($0)
			li $v0, 11
			syscall
			
			ble $t2, $t0, outer
	endOuter:
		lb $a0, newLine($0)
		li $v0, 11
		syscall
		lw $ra, ($sp)
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
