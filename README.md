# Hangman

Hangman - это консольная игра, суть которой в том, чтобы угадать загаданное слово. 
Вы должны спрашивать какую-нибудь букву, а система скажет угадали вы или нет. Ошибиться можно только 5 раз!

Для запуска игры у вас должна быть установлена Java 11+.

После скачивания игры запустите консоль, зайдите в папку, в которую была скачана игра, затем выполните:

```bash
java -jar hangman.jar
```

У вас запустится игра. Чтобы предположить букву напишите:

```
? <буква>
```

Чтобы выйти из игры напишите:

```
exit
```

Пример игры (загаданно слово "Hello"):

```
Starting Hangman game...
The word: *****
Guess a letter:
> ? l
Hit!
The word: **ll*
Guess a letter:
> ? H
Hit!
The word: H*ll*
Guess a letter:
> ? o
Hit!
The word: H*llo
Guess a letter:
> ? Q
Missed, mistake 1 out of 5
The word: H*llo
Guess a letter:
> ? l
This letter has been already asked... Mistake 2 out of 5
The word: H*llo
Guess a letter:
> ? e
You won!
Game is finished!
```