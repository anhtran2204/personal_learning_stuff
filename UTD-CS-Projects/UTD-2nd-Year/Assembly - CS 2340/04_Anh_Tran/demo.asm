.data
	salesPrompt: .asciiz "Number of round and square pizzas sold\n"
	roundsPrompt: .asciiz "- Rounds: "
	squaresPrompt: .asciiz "- Squares: "
	estimatePrompt: .asciiz "Estimation of total sq ft of pizzas sold: "
	profit: .asciiz "Woosh!"
	loss: .asciiz "Bummer!"
	space: .asciiz " "
	newLine: .asciiz "\n"
	
	totalPizzas: .word 0						# Total pizzas sold
	roundPizzas: .word 0						# Total round pizzas sold 
	squarePizzas: .word 0						# Total square pizzas sold
	roundSqFt: .word 0						# Round pizzas total square feet 
	squarePizzaSqFt: .float 0					# Square pizzas total square feet
	estimate: .float 0						# Estimate pizzas sold in square feet
	actual: .float 0						# Actual pizzas sold in square feet
	
	ZERO: .float 0.0						# Zero constant
	PI: .float 3.14159						# PI constant
	FOOT: .float 0.083						# 1 inch = 0.083 foot	
	RADIUS: .float 5 						# 10" diameter = 5" radius
	SIDE: .float 12							# Side of the square
	
.text

# Registers:
#   f0 -- Estimate
#   f1 -- zero const
#   f2 -- 
#   f3 -- 
#   f4 -- 
#   f5 -- 
#   f6 -- 
#   f7 -- 
#   f8 -- 

	
input:
	li $v0, 4
	la $a0, salesPrompt
	syscall
	
	li $v0, 4
	la $a0, roundsPrompt
	syscall
	
	li $v0, 5
	syscall
	sw $v0, roundPizzas
	
	lwc1 $f1, ZERO
	lwc1 $f2, FOOT
	lwc1 $f3, RADIUS
	lwc1 $f4, PI
	lwc1 $f5, roundPizzas
	
	mul.s $f6, $f3, $f4
	mul.s $f6, $f6, $f2
	
	add.s $f12, $f6, $f1
	li $v0, 2
	syscall
	
	c.eq.s $f1, $f2
	
	bc1f else
	li $v0, 4
	la $a0, profit
	syscall
	j exit
	
	else:
	li $v0, 4
	la $a0, loss
	syscall
	
	exit:
	li $v0, 10
	syscall