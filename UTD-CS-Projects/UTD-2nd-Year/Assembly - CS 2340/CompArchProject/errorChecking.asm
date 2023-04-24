.data 
	grid:	.asciiz ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", "."
		.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "
		.asciiz ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", "."
		.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "
		.asciiz ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", "."
		.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "
		.asciiz ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", "."
		.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "
		.asciiz ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", "."
		.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "
		.asciiz ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", "."

	invalidOutput: .asciiz "Sorry, the  coordinates that you entered is invalid\n"
	userWin: .asciiz "User wins!\n"
	compWin: .asciiz "Computer wins!\n"
	emptySpace: .asciiz " "
	horizontalLine: .asciiz "_"
	verticalLine: .asciiz "|"
	userMarker: .asciiz "X"
	compMarker: .asciiz "O"
	
	nrows: .word 11
	ncolumns: .word 15
	size: .word 165
	userCol: .word 0
	userRow: .word 0
	
	.eqv DATA_SIZE 8
	
.text
	la $a0, grid
	lw $a1, nrows 
	lw $a2, ncolumns
	
	li $v0, 5 
	syscall 
	sw $v0, userCol
	
	li $v0, 5 
	syscall 
	sw $v0, userRow 
	
	j end
	
	validInput:
	
		lw $t1, userCol
		lw $t0, userRow
		
		mul $t2, $t0, $a1
		add $t2, $t2, $t1 
		mul $t2, $t2, DATA_SIZE 
		add $t2, $t2, $a0
		
		lb $t3, ($t2)
		lb $t4, emptySpace($0)
		
		andi $t5, $t1, $t0
		andi $t5, $t5, 1
		addi $t6, $t6, 1
		beq $t5, $t6, invalidInput 
		bne $t3, $t4, invalidInput
		
		and $t5 $t0, 1
		beq $t0, $zero, horizontalRow
		
		lb $t4, verticalLine($0)
		sb $t4, ($t2)
		
		addi $a3, $zero, 0
		jr $ra
		horizontalRow:
		lb $t4, verticalLine($0)
		sb $t4, ($t2)
		
		addi $a3, $zero, 0
		jr $ra
		
		invalidInput:
		la $a0, invalidOutput
		li $v0, 4
		syscall 
		addi $a3, $a3, 1
		
		jr $ra 
		
		
	checkCompletion:
		li $t0, 0
		li $t1, 0
		li $t3, 0
		li $t4, 0
		
		gridLoop:
		mul $t2, $t0, $a1
		add $t2, $t2, $t1 
		mul $t2, $t2, DATA_SIZE 
		add $t2, $t2, $a0
		
		lb $t5, ($t2)
		lb $t6, emptySpace($0)
		
		beq $t5, $t6, incomplete
		
		lb $t6, userMarker($0)
		bne $t5, $t6, skip1
		addi $t3, $t3, 1
		
		skip1:
		lb $t6, compMarker($0)
		bne $t5, $t6, skip2
		addi $t4, $t4, 1
		
		skip2:
		
		addi $t0, $t0, 1
		lw $t7, nrows
		beq $t0, $t7, traverseRowReset
		j gridLoop
		
		traverseRowReset:
		sub $t0, $t0, $t0
		addi $t1, $t1, 1
		lw $t7, ncolumns
		
		beq $t0, $t7, completeGrid
		j gridLoop
		
		completeGrid:
		slt $t7, $t3, $t4
		bne $t7, $zero, computerWin
		
		userWins:
		la $a0, userWin
		li $v0, 4
		syscall 
		jr $ra
		
		computerWins:
		la $a0, compWin
		li $v0, 4
		syscall 
		jr $ra 
		
		incomplete:
		jr $ra 
	
	checkBox:
		lw $t1, userCol
		lw $t0, userRow
		
		andi $t2, $t0, 1
		beq $t1, $zero, isHorizontalCheck
		
		slt $t2, $t1, $a2
		beq $t2, $zero, verticalCheck2
		
		addi $t2, $t1, 2
		
		mul $t3, $t0, $a1
		add $t3, $t3, $t2 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		lb $t5, ($t3)
		lb $t6, verticalLine($0)
		
		bne $t5, $t6, verticalCheck2
		
		addi $t2, $t1, 1
		addi $t4, $t0, 1
		
		mul $t3, $t4, $a1
		add $t3, $t3, $t2 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		lb $t5, ($t3)
		lb $t6, horizontalLine($0)
		
		bne $t5, $t6, verticalCheck2
		
		addi $t2, $t1, 1
		addi $t4, $t0, -1
		
		mul $t3, $t4, $a1
		add $t3, $t3, $t2 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		lb $t5, ($t3)
		lb $t6, horizontalLine($0)
		
		bne $t5, $t6, verticalCheck2
		
		addi $t2, $t1, 1
		
		mul $t3, $t0, $a1
		add $t3, $t3, $t2 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		beq $t9, $zero, userMarker1
		lb $t4, compMarker($0)
		sb $t4, ($t3)
		j next1
		
		userMarker1:  
		lb $t4, userMarker($0)
		sb $t4, ($t3)
		
		next1:
		addi $a3, $a3, 1
		
		verticalCheck2:
		
		slt $t2, $zero, $t1
		beq $t2, $zero, exitBoxCheck
		
		addi $t2, $t1, -2
		
		mul $t3, $t0, $a1
		add $t3, $t3, $t2 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		lb $t5, ($t3)
		lb $t6, verticalLine($0)
		
		bne $t5, $t6, exitBoxCheck
		
		addi $t2, $t1, -1
		addi $t4, $t0, 1
		
		mul $t3, $t4, $a1
		add $t3, $t3, $t2 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		lb $t5, ($t3)
		lb $t6, horizontalLine($0)
		
		bne $t5, $t6, exitBoxCheck
		
		addi $t2, $t1, -1
		addi $t4, $t0, -1
		
		mul $t3, $t4, $a1
		add $t3, $t3, $t2 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		lb $t5, ($t3)
		lb $t6, horizontalLine($0)
		
		bne $t5, $t6, exitBoxCheck
		
		addi $t2, $t1, -1
		
		mul $t3, $t0, $a1
		add $t3, $t3, $t2 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		beq $t9, $zero, userMarker2
		lb $t4, compMarker($0)
		sb $t4, ($t3)
		j next2
		
		userMarker2:  
		lb $t4, userMarker($0)
		sb $t4, ($t3)
		
		next2:
		
		addi $a3, $a3, 1
		j exitBoxCheck
		
		isHorizontalCheck:
		
		slt $t2, $t0, $a1
		beq $t2, $zero, horizontalCheck2
		
		addi $t2, $t0, 2
		
		mul $t3, $t2, $a1
		add $t3, $t3, $t1 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		lb $t5, ($t3)
		lb $t6, horizontalLine($0)
		
		bne $t5, $t6, horizontalCheck2
		
		addi $t2, $t1, 1
		addi $t4, $t0, 1
		
		mul $t3, $t4, $a1
		add $t3, $t3, $t2 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		lb $t5, ($t3)
		lb $t6, verticalLine($0)
		
		bne $t5, $t6, horizontalCheck2
		
		addi $t2, $t1, -1
		addi $t4, $t0, 1
		
		mul $t3, $t4, $a1
		add $t3, $t3, $t2 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		lb $t5, ($t3)
		lb $t6, verticalLine($0)
		
		bne $t5, $t6, horizontalCheck2
		
		addi $t2, $t0, 1
		
		mul $t3, $t2, $a1
		add $t3, $t3, $t1 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		beq $t9, $zero, userMarker3
		lb $t4, compMarker($0)
		sb $t4, ($t3)
		j next3 
		
		userMarker3:  
		lb $t4, userMarker($0)
		sb $t4, ($t3)
		
		next3:
		addi $a3, $a3, 1
		
		horizontalCheck2:
		slt $t2, $zero, $t0
		beq $t2, $zero, exitBoxCheck
		
		addi $t2, $t0, -2
		
		mul $t3, $t2, $a1
		add $t3, $t3, $t1 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		lb $t5, ($t3)
		lb $t6, horizontalLine($0)
		
		bne $t5, $t6, exitBoxCheck
		
		addi $t2, $t1, 1
		addi $t4, $t0, -1
		
		mul $t3, $t4, $a1
		add $t3, $t3, $t2 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		lb $t5, ($t3)
		lb $t6, verticalLine($0)
		
		bne $t5, $t6, exitBoxCheck
		
		addi $t2, $t1, -1
		addi $t4, $t0, -1
		
		mul $t3, $t4, $a1
		add $t3, $t3, $t2 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		lb $t5, ($t3)
		lb $t6, horizontalLine($0)
		
		bne $t5, $t6, exitBoxCheck
		
		addi $t2, $t0, -1
		
		mul $t3, $t2, $a1
		add $t3, $t3, $t1 
		mul $t3, $t3, DATA_SIZE 
		add $t3, $t3, $a0
		
		beq $t9, $zero, userMarker4
		lb $t4, compMarker($0)
		sb $t4, ($t3)
		
		userMarker4:  
		lb $t4, userMarker($0)
		sb $t4, ($t3)
		j next4
		
		next4:
		addi $a3, $a3, 1
		
		j exitBoxCheck
		
		exitBoxCheck:
		addi $a3, $zero, 0
		jr $ra
		
	end:
		li $v0, 10 
		syscall
		
		
		
		
		
		
		
	
	
		
	

			

		
