	.data
board:	
		.byte	'.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'
		.byte 	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
		.byte	'.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'
		.byte 	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
		.byte	'.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'
		.byte 	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
		.byte	'.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'
		.byte 	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
		.byte	'.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'
		.byte 	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
		.byte	'.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'
		.byte 	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
		.byte	'.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.', ' ', '.'
		
rowLabel:	.byte 'A', 'B', 'C', 'D', 'E', 'F', 'G'
colLabel: 	.byte 1, 2, 3, 4, 5, 6, 7, 8, 9
rowSize:	.word 13
colSize:	.word 17
totalSize:	.word 221
newLine:	.byte '\n'
space:		.byte ' '
horiLine:	.byte '_'
vertLine:	.byte '|'
dots:		.byte '.'
player: 	.asciiz "P"
computer:	.asciiz	"C"

row:		.space 4
col: 		.space 4

## ========= GLOBAL REGISTERS ========= 
# t9 - Inner procedure register ptr.
# sp - Outer procedure register ptr.
# - Other registers are used differently
#   within separate procedures.
	.text
main:
	li $a0, 1
	li $a1, 0
	sb $a0, row
	sb $a1, col
	jal createBoard
	
	j exit
	
addSpace:
	lb $a0, space($0)
	li $v0, 11
	syscall
	jr $ra

addNewLine:
	lb $a0, newLine($0)
	li $v0, 11
	syscall
	jr $ra
	
printColLabel:
	sw $ra, ($sp)
	jal addSpace
	jal addSpace
	lw $s0, colSize
	li $t0, 0
	li $t1, 1
	loop:
		lb $a0, colLabel($t0)
		li $v0, 1
		syscall
		
		jal addSpace
		
		addi $t0, $t0, 1
		addi $t1, $t1, 2
		ble $t1, $s0, loop
		jal addNewLine
		lw $ra, ($sp)
		jr $ra
	
createBoard:
	move $t9, $ra
	jal printColLabel
	lw $t0, rowSize
	lw $t1, colSize
	
	lb $s4, row
	lb $s5, col
	
	li $t2, 0	# Outer loop counter
	li $t3, 0	# Row label index pointer
	li $t5, 0	# Board index pointer
	li $t6, 2	# Constant 2
	li $t7, 1	# Constant 1
	outer:	
		li $t4, 0	# Inner loop counter
		checkEmptyRows:
			div $t2, $t6
			mfhi $t8
			bne $t7, $t8, printLabel
			addi $t3, $t3, -1
			jal addSpace
			jal addSpace
			j inner
		
		printLabel:
			lb $a0, rowLabel($t3)
			li $v0, 11
			syscall
		
			jal addSpace
		inner:
			bne $s4, $t2, printNormal
			bne $s5, $t4, printNormal
			lb $a0, vertLine($0)
			li $v0, 11
			syscall
			j increment
			printNormal:
			lb $a0, board($t5)
			li $v0, 11
			syscall
			increment:
			addi $t4, $t4, 1
			addi $t5, $t5, 1
			
			blt  $t4, $t1, inner
		endInner:
			addi $t2, $t2, 1
			addi $t3, $t3, 1
			jal addNewLine
			blt $t2, $t0, outer
	endOuter:
		jal addNewLine
		move $ra, $t9
		jr $ra
	
exit:
	li $v0, 10
	syscall
