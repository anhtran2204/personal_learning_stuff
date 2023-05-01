	.data

		
rowLabel:	.byte 'A', 'B', 'C', 'D', 'E', 'F', 'G'	# Labels for each row
colLabel: 	.byte 1, 2, 3, 4, 5, 6, 7, 8, 9		# Labels for each column
rowSize:	.word 13
colSize:	.word 17
newLine:	.byte '\n'
space:		.byte ' '
horiLine:	.byte '_'
vertLine:	.byte '|'
dots:		.byte '.'
player: 	.asciiz "P"				# Character represent Player box
computer:	.asciiz	"C"				# Character represent Computer box

connection:	.space 4
#.include "board.asm"

## ========= GLOBAL REGISTERS ========= 
# t9 - Inner procedure register ptr.
# sp - Outer procedure register ptr.
# - Other registers are used differently
#   within separate procedures.
	.globl createBoard
	.text
createBoard:
	move $t9, $ra		# Store return address into $t9
	move $s4, $a1		# Retrieve row input of connection
	move $s5, $a2		# Retrieve col input of connection
	sb $a3, connection	# Retrieve the character of the connection '|' or '_'
	jal printColLabel	# Print the col labels
	
	lw $t0, rowSize		# Load max size of the rows of the board
	lw $t1, colSize 	# Load max size of the cols of the board
	
	li $t2, 0		# Outer loop counter
	li $t3, 0		# Row label index pointer
	li $t5, 0		# Board index pointer
	li $t6, 2		# Constant 2
	li $t7, 1		# Constant 1
	outer:	
		li $t4, 0	# Inner loop counter
		# Code block that check for empty rows to not print the label
		checkEmptyRows:
			div $t2, $t6			# Divide outer loop counter by 2
			mfhi $t8			# Get the remainder
			bne $t7, $t8, printLabel	# If the remainder is 0 then print label
			addi $t3, $t3, -1		# Else Decrement the row label counter
			jal addSpace
			jal addSpace
			j inner				# Continue
		
		printLabel:
			lb $a0, rowLabel($t3)		# Load the current row label in addr
			li $v0, 11
			syscall
		
			jal addSpace
		inner:
			#beq $s4, $0, printNormal	# If $s4 and $s5 is empty then print current board
			#beq $s5, $0, printNormal
			beq $a3, $0, printNormal
			bne $s4, $t2, printNormal	# Else consider the index that matches
			bne $s5, $t4, printNormal
			lb $a0, connection		# And print out the connection
			sb $a0, board($t5)		# And store the character in the board
			li $v0, 11
			syscall
			j increment
			printNormal:			# Print out the current board index
			lb $a0, board($t5)
			li $v0, 11
			syscall
			increment:
			addi $t4, $t4, 1		# Increment inner loop counter
			addi $t5, $t5, 1		# Increment board ptr
			
			blt  $t4, $t1, inner		# If inner loop counter less than max cols, loop again
		endInner:
			addi $t2, $t2, 1		# Else increment outer loop counter
			addi $t3, $t3, 1		# And increment row label ptr
			jal addNewLine
			blt $t2, $t0, outer		# If outer loop counter less than max rows, loop again
	endOuter:
		jal addNewLine			
		move $ra, $t9				# Else load return address and return
		jr $ra

addSpace:						# Function to print space
	lb $a0, space($0)
	li $v0, 11
	syscall
	jr $ra

addNewLine:						# Function to print a new line
	lb $a0, newLine($0)
	li $v0, 11
	syscall
	jr $ra
	
printColLabel:						# Function to print the col labels
	sw $ra, ($sp)					# Store return address on the stack
	jal addSpace
	jal addSpace
	lw $s0, colSize					# Load max col size
	li $t0, 0					# Col label ptr to iterate through
	li $t1, 1					# Loop counter
	loop:
		lb $a0, colLabel($t0)			# Print out the label
		li $v0, 1
		syscall
		
		jal addSpace
		
		addi $t0, $t0, 1			# Increment the ptr
		addi $t1, $t1, 2			# Increment the loop counter
		ble $t1, $s0, loop			# If counter < max col, loop again
		jal addNewLine
		lw $ra, ($sp)				# Else load return address and return
		jr $ra
