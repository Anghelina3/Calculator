# SmartCalculator

Простой умный калькулятор, который вычисляет математические выражения с поддержкой операторов и скобок.

## Возможности
- Вычисление выражений: `2 + 3 * (4 - 1)`
- Поддержка операторов: `+`, `-`, `*`, `/`, `^` (степень)
- Обработка скобок и приоритетов.

## Запуск
1. Убедитесь, что у вас установлена Java (версия 11+).
2. Скачайте проект:
```
git clone https://github.com/Anghelina3/Calculator.git
```

Соберите и запустите:

```
javac src/SmartCalculator/*.java
java src/SmartCalculator/Calculator
```
📝 Пример использования
```
Calculator calc = new Calculator();
double result = calc.calculate("3 + 5 * 2");  // Результат: 13.0
```
### Технологии

Java 11

Алгоритм сортировочной станции (Shunting Yard)