	.data
board:	
		.byte	'.', ' ', '.', ' ', '.'
		.byte 	' ', ' ', ' ', ' ', ' '
		.byte	'.', ' ', '.', ' ', '.'
		.byte 	' ', ' ', ' ', ' ', ' '
		.byte	'.', ' ', '.', ' ', '.'

rowSize:	.word 5
colSize:	.word 5		
newLine:	.byte '\n'
space:		.byte ' '
horiLine:	.byte '_'
vertLine:	.byte '|'
dots:		.byte '.'

	.text
main:
	lw $t0, rowSize
	lw $t1, colSize
	
	li $s0, 1
	li $s1, 0
	li $t2, 0	# Outer loop counter
	li $t5, 0	# Board index pointer
	outer:	
		li $t4, 0	# Inner loop counter
		inner:
			bne $s0, $t2, printNormal
			bne $s1, $t4, printNormal
			lb $a0, vertLine($0)
			sb $a0, board($t5)
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
		
	li $v0, 10
	syscall
		
addNewLine:
	lb $a0, newLine($0)
	li $v0, 11
	syscall
	jr $ra