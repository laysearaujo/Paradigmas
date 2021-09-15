from operator import itemgetter, attrgetter

aux = input().split(' ')
names = []
hits = {}

while(aux[0] != 'FIM'):
	names.append(aux)
	aux = input().split(' ')

sorteio = input().split('-')

hits = {}
for x in names:
	hits[x[0]] = 0

for x in names:
    if(hits[x[0]] != 0):
        hits[x[0]] = 0
    for z in range(1, len(x)):
        for y in sorteio:
            if(y == x[z]):
                hits[x[0]] +=1

myList = sorted(zip(hits.values(), hits.keys()), key=itemgetter(0,1))

for i in myList:
    if(i[0] == 0):
        print(i[1] + ' ')
    else:
        print(i[1] + ' ' + i[0] * '+')