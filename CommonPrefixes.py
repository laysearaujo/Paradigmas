linha = []
aux = {}
resultado = {}

n, k = map(int, input().split())

for i in range(0, n):
    linha.append(input())
    palavra = linha[i]
    for index in range(1, (len(palavra) + 1)):
        if palavra[0:index] in aux: aux[palavra[0:index]] += 1
        else: aux[palavra[0:index]] = 1
        if (aux[palavra[0:index]] >= k): resultado[palavra[0:index]] = k

print(len(resultado))
for key in sorted(resultado.keys()): print(key)