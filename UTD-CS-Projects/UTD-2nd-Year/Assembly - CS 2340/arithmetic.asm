	.text
	li $t0, 1
	li $t1, 2
	li $t3, 3
	li $t4, 4
	
	add $t5, $t0, $t1
	add $t6, $t2, $t3
	add $t5, $t5, $t6
	
	li $v0, 1
	move $a0, $t5
	syscall
