program recursion;

function digitoMaximo(n: integer; max: integer):integer;
var
  dig: integer;
begin
  if (n = 0) then
     digitoMaximo:=n
  else
      begin
         dig:= n mod 10;
         if ( dig > max ) then begin
             max:= dig;
         end;
         n:= n div 10;
         if (n <> 0) then
            max:=digitoMaximo(n,max);
      end;
  digitoMaximo:= max;


end;

var
  num, max: integer;
Begin
  max := -1;
  writeln( 'Ingrese un entero no negativo:');
  readln (num);
  writeln ( 'El digito maximo del numero ', num, ' es: ',digitoMaximo (num, max));
  readln;
End.

