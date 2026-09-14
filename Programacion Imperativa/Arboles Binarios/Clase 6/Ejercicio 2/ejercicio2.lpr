program ejercicio2;
type
  vuelo=record
    codigo:string;
    millas:integer;
    dni:integer;
    nombreApellido:string;
    clase:string;
  end;

  lista=^nodo;
  nodo=record
    dato:vuelo;
    sig:lista;
  end;

  //Estructura para el arbol
  //1) lista para guardar codigo y puntos de cada vuelo
  puntajes=record
    codigo:string;
    puntos:integer;
  end;

  listaP=^nodoP;
  nodoP=record
    dato:puntajes;
    sig:listaP;
  end;
  //2)Registro que va hacer el tipo de dato qeu guarda el arbol
  pasajero=record
    dni:integer;
    nombreApellido:string;
    puntajes:listaP;
  end;
  //3)Estructura del arbol
  arbol=^nodoA;
  nodoA=record
    dato:pasajero;
    hi:arbol;
    hd:arbol;
  end;
  //4)Registro de dni y ganador de puntos
  ganador=record
    dni:integer;
    puntos:integer;
  end;



procedure InsertarOrdenado(var l:lista; d:vuelo);
var
  act,ant,nue:lista;
begin
  new(nue);
  nue^.dato:=d;
  nue^.sig:=nil;
  act:=l;
  ant:=l;
  while(act <> nil) and (act^.dato.codigo < d.codigo) do
        begin
          ant:=act;
          act:=act^.sig;
        end;

  if(act = ant) then
    l:=nue
  else
    ant^.sig:=nue;

  nue^.sig:=act;
end;

//procedure CargarLista(var l:lista); //Simular Carga random de ventas de vuelo
procedure CargarLista(var l: lista);
var
  i, cant: integer;
  d: vuelo;
  numStr: string;
begin
  // Genera entre 15 y 30 ventas aleatorias
  cant := 15 + random(16);

  for i := 1 to cant do
  begin
    // Codigo de vuelo tipo 'AR' + numero entre 100 y 999
    str(100 + random(900), numStr);
    d.codigo := 'AR' + numStr;

    // Millas entre 50 y 2000
    d.millas := 50 + random(1951);

    // DNI concentrado entre 38.000.000 y 52.000.000 para probar repetidos y el rango del inciso c
    d.dni := 38000000 + random(15000000);

    d.nombreApellido := 'Pasajero Aleatorio';

    // Clase asignada al azar (0 = turista, 1 = ejecutiva)
    if (random(2) = 0) then
      d.clase := 'turista'
    else
      d.clase := 'ejecutiva';

    // Inserta manteniendo la lista ordenada por codigo
    InsertarOrdenado(l, d);
  end;
end;


function obtenerPuntos(clase:string; millas:integer):integer;
begin
  if(clase = 'ejecutiva') then
    obtenerPuntos:=100 * millas
  else
   if(clase = 'turista') then
    obtenerPuntos:=25 * millas
  else
    obtenerPuntos:=0;
end;

procedure AgregarAdelanteLista(var l:listaP; d:vuelo);
var
  nue:listaP;
begin
  new(nue);
  nue^.dato.codigo:=d.codigo;
  nue^.dato.puntos:=obtenerPuntos(d.clase,d.millas);
  nue^.sig:=l;
  l:=nue;
end;

{-----------------------------------------------------------------------------
INSERTAR - Insertar en arbol - Con repetidos }
procedure Insertar(var a:arbol; d: vuelo);
begin
 if(a = nil) then
   begin
    new(a);
    a^.dato.dni:= d.dni;
    a^.dato.nombreApellido:= d.nombreApellido;
    a^.dato.puntajes:=nil;
    a^.hi := nil;
    a^.hd := nil;
    AgregarAdelanteLista(a^.dato.puntajes,d);
   end
 else
  if(d.dni < a^.dato.dni) then
    Insertar(a^.hi,d)
 else
  if(d.dni > a^.dato.dni) then
    Insertar(a^.hd,d)
 else
   begin
    AgregarAdelanteLista(a^.dato.puntajes,d);
   end;
end;

procedure ProcesarListaDeVentas(l:lista; var a:arbol);
begin
 while(l <> nil) do
   begin
     Insertar(a,l^.dato);
     l:=l^.sig;
   end;
end;

function CalcularTotalPuntos(l:listaP):integer;
var
  tot:integer;
begin
 tot:=0;
 while(l <> nil) do
   begin
     tot:=tot + l^.dato.puntos;
     l:=l^.sig;
   end;
 CalcularTotalPuntos:=tot;
end;

{----------------------------------------------------------------------------
Izquierda -> Raiz -> Derecha}
procedure CalcularGanadorEnOrden(a: arbol;var max:ganador);
var
  tot:integer;
begin
 if(a <> nil) then
   begin
     CalcularGanadorEnOrden(a^.hi,max);
     tot:=CalcularTotalPuntos(a^.dato.puntajes);
     if(tot > max.puntos) then
       begin
         max.dni:=a^.dato.dni;
         max.puntos:=tot;
       end;
     CalcularGanadorEnOrden(a^.hd,max);
   end;
end;

function MaximoPuntaje(l:listaP):integer;
var
  max:integer;
begin
  max:=-1;
  while(l <> nil) do
    begin
      if(l^.dato.puntos > max) then
        max:= l^.dato.puntos;
      l:=l^.sig;
    end;
  MaximoPuntaje:=max;
end;

procedure verMaximoEnRango(a: arbol; min:integer; max:integer);
begin
    if (a <> nil) then
    if (a^.dato.dni >= min) then
      if (a^.dato.dni <= max) then begin
        writeln('El mayor puntaje de: ',a^.dato.dni,' es: ',MaximoPuntaje(a^.dato.puntajes));
        verMaximoEnRango(a^.hi, min, max);
        verMaximoEnRango(a^.hd, min, max);
      end
      else
        verMaximoEnRango(a^.hi, min, max)
    else
      verMaximoEnRango(a^.hd, min, max);
end;

var
  l:lista;
  a:arbol;
  max:ganador;
begin
  randomize;

  l:=nil;
  a:=nil;
  max.puntos:=-1;

  CargarLista(l);

  ProcesarListaDeVentas(l,a);
  CalcularGanadorEnOrden(a,max);
  writeln('El ganador del premio al mejor cliente es ',max.dni,' con : ',max.puntos,' puntos');
  verMaximoEnRango(a,40000000,50000000);

  readln;
end.










