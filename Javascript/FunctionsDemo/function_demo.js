function factorial(n) {
    if (n <= 1) {
        return 1;
    }
    console.log(n);
    return n * factorial(n - 1);
}

function fibonacci(n) {
    if (n == 0) {
        return 0;
    }
    if (n == 1) {
        return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.question("Enter the number: ", function (num) {
  console.log(factorial(num));
  console.log(fibonacci(num)); 
  rl.close();
});
