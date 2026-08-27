program calculodepotencia;

function Potencial(x,n:integer):integer;
begin
  if(n = 0) then
    Potencial:=1
  else
    Potencial:=x * Potencial(x,n-1);
end;

{PROGRAMA PRINCIPAL}
var
   n, x: integer;

begin

     write ('Ingrese base: ');
     Readln (x);
     write ('Ingrese exponente: ');
     Readln (n);
     writeln('Resultado : ',Potencial(x,n));

     readln;
end.
