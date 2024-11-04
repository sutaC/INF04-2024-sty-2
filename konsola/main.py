#!/bin/python

# ************************************************
#  klasa: ChainOperator
#  opis: Biblioteka do wykonywania oepracji na łańcuchach
#  metody: countVowels - (int) liczba samogłosek w łańcuchu 
#          stripRepeatingChars - (str) kopia łańcucha bez powtarzających się znaków
#  autor: XYZ
# ************************************************
class ChainOperator:    
    @staticmethod
    def countVowels(text: str) -> int:
        if not text or len(text) == 0:
            return 0
        VOWELS = "aąeęiouóyAĄEĘIOUÓY"
        count = 0
        for char in text:
            if VOWELS.find(char) > -1:
                count += 1
        return count

    @staticmethod
    def stripRepeatingChars(text: str) -> str:
        if(not text or len(text) == 0):
            return ""
        out = ""
        for i in range(len(text)):
            if i == len(text) - 1:
                out += text[i]
            elif text[i] != text[i+1]:
                out += text[i]
        return out

# Start
print("Program testujący bibliotekę operatora łańcuchów")
text = input("Podaj łańcuch: ")
vowels = ChainOperator.countVowels(text)
print(f"Liczba samogłosek w łańcuchu: {vowels}")
stripped = ChainOperator.stripRepeatingChars(text)
print(f"Łańcuch po usunięciu powtórzeń: {stripped}")
