def get_qtd():
  qtd = int(input())
  return qtd
  
def translate(qtd):
  translated = []
  translation_dict = {}
  for _ in range(qtd):
    line = str(input())
    fragments = line.split(" => ")
    translated.append(fragments[1])
    
    translation_dict[fragments[0]] = fragments[1]
  
  return translation_dict

translations = translate(get_qtd())

while True:
  text = str(input())

  if(text == '*'):
    break;
  
  try:
    frag = text.split(" ")

  except:
    frag = [text]

  y = list(map(lambda x: translations[x] ,frag))
  
  print(' '.join(y))