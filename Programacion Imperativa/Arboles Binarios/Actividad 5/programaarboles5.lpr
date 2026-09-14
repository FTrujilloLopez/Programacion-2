Program programaarboles5;
Type

  // Lista de enteros
  lista = ^nodoL;
  nodoL = record
    dato: integer;
    sig: lista;
  end;

  // Arbol de enteros
  arbol= ^nodoA;
  nodoA = Record
    dato: integer;
    HI: arbol;
    HD: arbol;
  End;

  // Lista de Arboles
  listaNivel = ^nodoN;
  nodoN = record
    info: arbol;
    sig: listaNivel;
  end;


{-----------------------------------------------------------------------------
AgregarAdelante - Agrega nro adelante de l}
procedure agregarAdelante(var l: Lista; nro: integer);
var
  aux: lista;
begin
  new(aux);
  aux^.dato := nro;
  aux^.sig := l;
  l:= aux;
end;



{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista con números aleatorios }
procedure crearLista(var l: Lista);
var
  n: integer;
begin
 l:= nil;
 n := random (20);
 While (n <> 0) do Begin
   agregarAdelante(L, n);
   n := random (20);
 End;
end;


{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista(l: Lista);
begin
 While (l <> nil) do begin
   write(l^.dato, ' - ');
   l:= l^.sig;
 End;
end;

{-----------------------------------------------------------------------------
CONTARELEMENTOS - Devuelve la cantidad de elementos de una lista l }

function ContarElementos (l: listaNivel): integer;
  var c: integer;
begin
 c:= 0;
 While (l <> nil) do begin
   c:= c+1;
   l:= l^.sig;
 End;
 contarElementos := c;
end;


{-----------------------------------------------------------------------------
AGREGARATRAS - Agrega un elemento atrás en l}

Procedure AgregarAtras (var l, ult: listaNivel; a:arbol);
 var nue:listaNivel;

 begin
 new (nue);
 nue^.info := a;
 nue^.sig := nil;
 if l= nil then l:= nue
           else ult^.sig:= nue;
 ult:= nue;
 end;


{-----------------------------------------------------------------------------
IMPRIMIRPORNIVEL - Muestra los datos del árbol a por niveles }

Procedure imprimirpornivel(a: arbol);
var
   l, aux, ult: listaNivel;
   nivel, cant, i: integer;
begin
   l:= nil;
   if(a <> nil)then begin
                 nivel:= 0;
                 agregarAtras (l,ult,a);
                 while (l<> nil) do begin
                    nivel := nivel + 1;
                    cant:= contarElementos(l);
                    write ('Nivel ', nivel, ': ');
                    for i:= 1 to cant do begin
                      write (l^.info^.dato, ' - ');
                      if (l^.info^.HI <> nil) then agregarAtras (l,ult,l^.info^.HI);
                      if (l^.info^.HD <> nil) then agregarAtras (l,ult,l^.info^.HD);
                      aux:= l;
                      l:= l^.sig;
                      dispose (aux);
                     end;
                     writeln;
                 end;
               end;
end;

{-----------------------------------------------------------------------------
Modulo de insertar dato en arbol ordenadamente con recursividad  B)---}

procedure Insertar(var a:arbol ; d: integer);
begin
  if(a = nil) then
    begin
     new(a);
     a^.dato:=d;
     a^.HI:= nil;
     a^.HD:= nil;
    end
  else
    if(a^.dato > d) then
      Insertar(a^.HI,d)
    else
      Insertar(a^.HD,d);
end;

{-----------------------------------------------------------------------------
Carga el arbol binario odenado con los datos de la lista C)---}
procedure CargarArbolConLista(var a:arbol; l:lista);
begin
 while(l <> nil) do
   begin
     Insertar(a,l^.dato);
     l:=l^.sig;
   end;
end;

{--Actividad 3--}

{----------------------------------------------------------------------------
Izquierda -> Raiz -> Derecha}
procedure EnOrden(a: arbol);
begin
 if(a <> nil) then
   begin
     EnOrden(a^.HI);
     write(a^.dato,' - ');
     EnOrden(a^.HD);
   end;
end;

{----------------------------------------------------------------------------
Raiz -> Izquierda -> Derecha}
procedure PreOrden(a: arbol);
begin
 if(a <> nil) then
   begin
     write(a^.dato,' - ');
     PreOrden(a^.HI);
     PreOrden(a^.HD);
   end;
end;

{----------------------------------------------------------------------------
Izquierda -> Derecha -> Raiz}

procedure PostOrden(a: arbol);
begin
 if(a <> nil) then
   begin
    PostOrden(a^.HI);
    PostOrden(a^.HD);
    write(a^.dato,' - ');
   end;
end;

{-- Actividad 4 --}

{----------------------------------------------------------------------------
Modulo Buscar - Devuelve un puntero }

function Buscar(a: arbol; d:integer):arbol;
begin
 if(a = nil) or (a^.dato = d) then
   Buscar:=a
 else
   if(a^.dato > d) then
     Buscar:=Buscar(a^.HI,d)
 else
   if(a^.dato < d) then
     Buscar:=Buscar(a^.HD,d);
end;

{-- Actividad 5 --}
{----------------------------------------------------------------------------
Valor minimo del arbol a) }
function VerMin(a: arbol):integer;
begin
 if(a = nil) then
   VerMin:= -1
 else
   if(a^.HI = nil) then
     VerMin:=a^.dato
 else
   VerMin:=VerMin(a^.HI);
end;

{----------------------------------------------------------------------------
Valor maximo del arbol B) }
function VerMax(a: arbol):integer;
begin
 if(a = nil) then
   VerMax:= -1
 else
   if(a^.HD = nil) then
     VerMax:=a^.dato
 else
   VerMax:=VerMax(a^.HD);
end;

Var
 a: arbol;
 l: lista;
 d:integer;

begin
 Randomize;

 a:=nil;

 crearLista(l);
 writeln ('Lista generada: ');
 imprimirLista(l);
 writeln('');
 writeln('');

 CargarArbolConLista(a,l);
 imprimirpornivel(a);

 writeln('PreOrden ');
 PreOrden(a);

 writeln('');
 writeln('');

 writeln('EnOrden ');
 EnOrden(a);

 writeln('');
 writeln('');

 writeln('PostOrden ');
 PostOrden(a);

 writeln('');
 writeln('');

 write('Dato a buscar: ');
 readln(d);

 writeln('');
 writeln('');

 if(Buscar(a,d) = nil) then
   writeln('NIL - No se encontro')
 else
   writeln('Se encontro: ',d);

 writeln('');
 writeln('');

 writeln('Minimo valor del arbol: ',verMin(a));

 writeln('');
 writeln('');

 writeln('Maximo valor del arbol: ',verMax(a));

 readln;

end.
