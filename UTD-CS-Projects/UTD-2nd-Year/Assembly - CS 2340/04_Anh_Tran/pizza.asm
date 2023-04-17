.data
	salesPrompt: .asciiz "Number of round and square pizzas sold\n"
	roundsPrompt: .asciiz "- Rounds: "
	squaresPrompt: .asciiz "- Squares: "
	estimatePrompt: .asciiz "Estimation of total sq ft of pizzas sold: "
	totalPizzasSqFt: .asciiz "- Number of square feet of pizzas sold: "
	totalRoundPizzasSqFt: .asciiz "- Number of square feet of round pizzas: "
	totalSquarePizzasSqFt: .asciiz "- Number of square feet of square pizzas: "
	profit: .asciiz "Woosh!"
	loss: .asciiz "Bummer!"
	space: .asciiz " "
	newLine: .asciiz "\n"
	
	totalPizzas: .word 0							# Total pizzas sold
	roundPizzas: .word 0							# Total round pizzas sold 
	squarePizzas: .word 0							# Total square pizzas sold
	roundSqFt: .word 0							# Round pizzas total square feet 
	squareSqFt: .float 0							# Square pizzas total square feet
	estimate: .float 0							# Estimate pizzas sold in square feet
	actual: .float 0							# Actual pizzas sold in square feet
	
	ZERO: .float 0.0							# Zero constant
	PI: .float 3.14159							# PI constant
	SQ_INCHES: .float 144.0							# 1 inch = 0.083 foot	
	RADIUS: .float 5 							# 10" diameter = 5" radius
	SIDE: .word 12								# Side of the square
	
.text

# Registers:
#   f0 -- Estimate guess input
#   f1 -- zero constant
#   f2 -- const for in to ft conversion
#   f3 -- RADIUS
#   f4 -- PI
#   f5 -- placeholder for int equivalent of Round pizzas
#   f6 -- 
#   f7 -- 
#   f8 -- 
#         placeholder for int equivalent of Square pizzas
	
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
	
	li $v0, 4
	la $a0, squaresPrompt
	syscall
	
	li $v0, 5
	syscall
	sw $v0, squarePizzas
	
	li $v0, 4
 	la $a0, newLine
 	syscall
	
 	li $v0, 4
 	la $a0, estimatePrompt
 	syscall
 	
 	li $v0, 6
 	syscall
 	swc1 $f0, estimate
	
calculations:
	lwc1 $f1, ZERO
	lwc1 $f2, SQ_INCHES
	lwc1 $f3, RADIUS
	lwc1 $f4, PI
	lw $s0, SIDE
	lw $s1, roundPizzas
	lw $s2, squarePizzas
	
	round:	
	mtc1 $s1, $f5							# Load num of round pizzas onto floating point register
	cvt.s.w $f5, $f5						# Convert the interger equivalent into floating point
	mul.s $f6, $f3, $f3						# Radius^2
	mul.s $f7, $f4, $f6						# Circle area = PI * Radius^2
	mul.s $f8, $f7, $f5 						# Total sq inches of round pizzas = Area * Num of pizzas
	div.s $f8, $f8, $f2						# Convert total sq inches in to sq ft
	
	square:
	mtc1 $s2, $f9							# Load num of square pizzas onto floating point register
	cvt.s.w $f9, $f9						# Convert the interger equivalent into floating point
	mult $s0, $s0							# Square area = Side * Side
	mflo $t0							# Load from LO 32-bits product onto the register
	mtc1 $t0, $f10							# Load the product onto floating point register
	cvt.s.w $f10, $f10						# Convert the interger equivalent into floating point
	mul.s $f11, $f10, $f9						# Total sq inches of square pizzas = Area * Num of Pizzas
	div.s $f11, $f11, $f2						# Convert total sq inches in to sq ft
	
	swc1 $f8, roundSqFt
	swc1 $f11, squareSqFt
	
sales:
	li $v0, 4
 	la $a0, totalPizzasSqFt
 	syscall
 	
 	add.s $f13, $f8, $f11						# Add round and square to get total square feet
 	add.s $f12, $f13, $f1
 	li $v0, 2
 	syscall
 	
 	li $v0, 4
 	la $a0, newLine
 	syscall
 	
 	li $v0, 4
 	la $a0, totalRoundPizzasSqFt
 	syscall
 	
 	add.s $f12, $f8, $f1
 	li $v0, 2
 	syscall
 	
 	li $v0, 4
 	la $a0, newLine
 	syscall
 	
 	li $v0, 4
 	la $a0, totalSquarePizzasSqFt
 	syscall
 	
 	add.s $f12, $f11, $f1
 	li $v0, 2
 	syscall
 	
 	li $v0, 4
 	la $a0, newLine
 	syscall
	
profitOrLoss:
	lwc1 $f14, estimate						# Load estimation sales onto floating point register
	c.lt.s $f14, $f13						# Compare if estimate is less than actual, if true then branch
	bc1t else
	li $v0, 4
 	la $a0, loss
 	syscall
 	j exit
 	
	else:
	li $v0, 4
 	la $a0, profit
 	syscall

exit:
	li $v0, 10
	syscall
