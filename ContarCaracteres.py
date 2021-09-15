class Frase:
    def __init__(self, str):
        self.text = str
    
    def spaces(self):
        return print(self.text.count(" "))
    
    def letterA(self):
        return print(self.text.count("a"))

    def pairFrequency(self):
        aux = []
        for index in range(1, (len(self.text))):
            if ((ord(self.text[index]) > 64) & (ord(self.text[index]) < 91) | (ord(self.text[index]) > 96) & (ord(self.text[index]) < 123)) & ((ord(self.text[index - 1]) > 64) & (ord(self.text[index - 1]) < 91) | (ord(self.text[index - 1]) > 96) & (ord(self.text[index - 1]) < 123)):
                aux.append(self.text[index - 1]+self.text[index])
        if len(aux) != 0:
            frequency = 0
            pair = ""
            for p in aux:
                frequencyAux = aux.count(p)
                if frequencyAux > frequency:
                    frequency = frequencyAux
                    pair = p
            print(frequency)    
            return print(pair)
        else: return print("NENHUM PAR")

while 1:
    line = input()
    if line == "NAO QUERO MAIS": exit()
    else:
        frase = Frase(line.lower())
        frase.spaces()
        frase.letterA()
        frase.pairFrequency()