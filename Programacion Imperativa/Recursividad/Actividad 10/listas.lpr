Program listas;
Type
  Lista= ^Nodo;
  Nodo= Record
           Datos: integer;
           Sig: Lista;
        End;
Var
 L: Lista;
 n: integer;

Procedure AgregarAdelante (var L:lista; num:integer);
Var nue:Lista;
  Begin
    New(nue);
    nue^.datos:=num;
    nue^.sig:=L;
    L:=nue;
  End;


Procedure Imprimir (pri:lista);
Begin
   while (pri <> NIL) do begin
     write (pri^.datos, ' ');
     pri:= pri^.sig
  end;
  writeln;
end;
// Modulo para encontrar el valor minimo de la lista utilizando recusividad //
function ValorMinimo(l:Lista):integer;
var
 min:integer;
begin
  if(l = nil) then
    ValorMinimo:=9999999
  else
    begin
      min:=ValorMinimo(l^.sig);
      if(l^.datos < min) then
        ValorMinimo:=l^.datos
      else
        ValorMinimo:=min;
    end;
end;
// Imprimir utilizando recursividad //
procedure ImprimirR(l:Lista);
begin
  if(l <> nil) then
    begin
     Write(l^.datos,' ');
     ImprimirR(l^.sig);
    end;
end;


begin
 L:=nil;
 randomize;
 n := random (100);
 While (n<>0) do Begin
   AgregarAdelante (L, n);
   n := random (100);
 End;
 writeln ('Lista generada: ');
 imprimir (L);
 writeln ('Valor Minimo: ',ValorMinimo(L));
 ImprimirR(l);
 readln
end.
