program programaencomiendas9;
Type

   encomienda = record
                  codigo: integer;
                  peso: integer;
                end;



  // Lista de encomiendas
  lista = ^nodoL;
  nodoL = record
    dato: encomienda;
    sig: lista;
  end;

  // Lista de codigos
  listaC = ^nodoC;
  nodoC = record
    dato:integer;
    sig:listaC;
  end;

  //Registro para guardar codigos por peso
  PesoCod=record
    peso:integer;
    codigo:listaC;
  end;

  // Arbol de enteros
  arbol= ^nodoA;
  nodoA = Record
    dato: pesoCod;
    HI: arbol;
    HD: arbol;
  End;


{-----------------------------------------------------------------------------
AgregarAdelante - Agrega una encomienda adelante en l}
procedure agregarAdelanteLista1(var l: Lista; enc: encomienda);
var
  aux: lista;
begin
  new(aux);
  aux^.dato := enc;
  aux^.sig := l;
  l:= aux;
end;


{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista con datos de las encomiendas }
procedure crearLista(var l: Lista);
var
  e: encomienda;
  i: integer;
begin
 l:= nil;
 for i:= 1 to 20 do begin
   e.codigo := i;
   e.peso:= random (10);
   while (e.peso = 0) do e.peso:= random (10);
   agregarAdelanteLista1(L, e);
 End;
end;


{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista1(l: Lista);
begin
 While (l <> nil) do begin
   writeln('Codigo: ', l^.dato.codigo, '  Peso: ', l^.dato.peso);
   l:= l^.sig;
 End;
end;

{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista 2 }
procedure imprimirLista2(l: ListaC);
begin
 write('Codigos: ');
 While (l <> nil) do begin
   write(l^.dato,' - ');
   l:= l^.sig;
 End;
end;

{-----------------------------------------------------------------------------
AgregarAdelanteLista2 - Agrega codigo adelante en la lista del arbol }

procedure AgregarAdelanteLista2(var l:listaC; d:integer);
var
  nue:listaC;
begin
  new(nue);
  nue^.dato:=d;
  nue^.sig:=l;
  l:=nue;
end;

{-----------------------------------------------------------------------------
INSERTAR - Insertar en arbol - Actividad 9 - A)}
procedure Insertar(d: encomienda;var a:arbol);
begin
 if(a = nil) then
   begin
    new(a);
    a^.dato.peso := d.peso;
    a^.dato.codigo := nil;
    a^.HI := nil;
    a^.HD := nil;
    AgregarAdelanteLista2(a^.dato.codigo,d.codigo);
   end
 else
  if(d.peso < a^.dato.peso) then
    Insertar(d,a^.HI)
 else
  if(d.peso > a^.dato.peso) then
    Insertar(d,a^.HD)
 else
   begin
    AgregarAdelanteLista2(a^.dato.codigo,d.codigo);
   end;
end;

{-----------------------------------------------------------------------------
Cargar Lista del arbol - Modulo Auxiliar de A) }
procedure CargarArbolConLista(l:lista ;var a:arbol);
begin
 while (l <> nil) do
   begin
    Insertar(l^.dato,a);
    l:=l^.sig;
   end;
end;

{----------------------------------------------------------------------------
Izquierda -> Raiz -> Derecha}
procedure EnOrden(a: arbol);
begin
 if(a <> nil) then
   begin
     EnOrden(a^.HI);
     write('Peso : ',a^.dato.peso,' : ');
     ImprimirLista2(a^.dato.codigo);
     writeln();
     EnOrden(a^.HD);
   end;
end;


Var

 l: lista;
 a: arbol;

begin
 Randomize;
 a := nil;

 crearLista(l);
 writeln ('Lista de encomiendas generada: ');
 imprimirLista1(l);
 CargarArbolConLista(l,a);
 writeln();
 writeln();
 EnOrden(a);


 readln;
end.


