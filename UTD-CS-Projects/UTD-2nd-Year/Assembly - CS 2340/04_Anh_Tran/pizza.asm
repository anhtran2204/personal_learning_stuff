.data
	salesPrompt: .asciiz "Number of round and square pizzas sold: "
	estimatePrompt: .asciiz "Estimation of total pizzas sold: "
	profit: .asciiz "Woosh!"
	loss: .asciiz "Bummer!"
	space: .asciiz " "
	newLine: .asciiz "\n"
	
	totalPizzas: .word 0
	roundPizzas: .word 0
	squarePizzas: .word 0
	estimate: .word 0
	
.text

main:
			
		