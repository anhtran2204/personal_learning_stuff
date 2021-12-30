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

// const readline = require('readline');

// const rl = readline.createInterface({
//     input: process.stdin,
//     output: process.stdout,
// });

// rl.question("Enter a number: ", function(answer) {
//     switch (+answer) {
//         case 1:
//             rl.question("What's your name? ", function(user_name) {
//                 console.log(`Your name is ${user_name}`);
//                 rl.close();
//             });
//             break;

//         case 2:
//             rl.close();
//             rl.question("What's your age? ", function(age)  {
//                 console.log(`Your age is ${age}`);
//                 rl.close();
//             });
//             break;

//         default:
//             console.log("Nothing to show here!");
//             rl.close();
//             break;
//     }
// });


var num = window.prompt("Enter a number: ");

switch(+num) {
    case 1:
        var user_name = window.prompt("What's your name? ");
        console.log("Your name is", user_name);
        break;

    case 2:
        var age = window.prompt("What's your age? ");
        console.log("Your age is", age);
        break;

    default:
        console.log("Nothing to show here!");
        break;
}
