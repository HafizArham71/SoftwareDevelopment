#include <iostream>

int main() {
    double num1, num2;
    char op;

    std::cout << "Enter first number: ";
    std::cin >> num1;

    std::cout << "Enter operator (+, -, *, /): ";
    std::cin >> op;

    std::cout << "Enter second number: ";
    std::cin >> num2;

    if (op == '+')
        std::cout << "Result: " << num1 + num2 << std::endl;
    else if (op == '-')
        std::cout << "Result: " << num1 - num2 << std::endl;
    else if (op == '*')
        std::cout << "Result: " << num1 * num2 << std::endl;
    else if (op == '/') {
        if (num2 != 0)
            std::cout << "Result: " << num1 / num2 << std::endl;
        else
            std::cout << "Error: Division by zero!" << std::endl;
    } else
        std::cout << "Invalid operator!" << std::endl;

    return 0;
}
