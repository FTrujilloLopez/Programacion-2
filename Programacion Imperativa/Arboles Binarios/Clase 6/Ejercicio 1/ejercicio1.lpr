Program ejercicio1;
Uses
     sysutils;
Type
     str10= string[10];
     jugador = record
              dni: longint;
	          nombreApellido: string;
	          posicion: str10;
              puntaje: integer;
     end;

     lista = ^nodoLista;
     nodoLista = record
               dato: jugador;
               sig: lista;
     end;

     partido= record
               estadio: string;
               equipoLocal: string;
               equipoVisitante: string;
               fecha: str10;
               jugadores: lista;
     end;

     listaPartidos = ^nodoPartido;
     nodoPartido = record
               dato: partido;
               sig: listaPartidos;
     end;

// Estructura Nueva  a)

     r_partido = record
               fecha:string;
               puntaje:integer;
     end;

     l_partido = ^nodoP;
     nodoP = record
               dato:r_partido;
               sig:l_partido;
     end;

     jugador2 = record
            dni:longint;
            nombreApellido:string;
            posicion:string;
            partido: l_partido;

     end;

// Estructura del arbol a)

    arbol = ^nodoA;
    nodoA = record
           dato:jugador2;
           hi:arbol;
           hd:arbol;
     end;


procedure cargarFecha(var s: str10);
var
  dia, mes: integer;
begin
  dia := random(30)+1;
  mes := random(12)+1;
  if(mes = 2) and (dia > 28)then
	dia := 31;
  if((mes = 4) or (mes = 6) or (mes =9) or (mes = 11)) and (dia = 31)then
	dia := 30;
  s := Concat('2022/',IntToStr(mes),'/',IntToStr(dia));
end;

Procedure agregar(var l: listaPartidos; p: partido);
var
   aux: listaPartidos;
begin
     new(aux);
     aux^.dato := p;
     aux^.sig := l;
     l:= aux;
end;

Procedure agregarJugador(var l: lista; j: jugador);
var
   aux: lista;
begin
     new(aux);
     aux^.dato := j;
     aux^.sig := l;
     l:= aux;
end;

procedure cargarJugadores(var l: lista);
var
   j: jugador;
   cant, i, pos: integer;
begin
     cant := random(10)+22;
     for i:=1 to cant do
     begin
          with(j) do begin
              dni := random(36000000)+20000000;
	      nombreApellido:= Concat('Jugador-', IntToStr(dni));
	      pos:= random(4)+1;
              case pos of
                1: posicion:= 'arquero';
                2: posicion:= 'defensa';
                3: posicion:= 'mediocampo';
                4: posicion:= 'delantero';
              end;
              puntaje:= random(10)+1;
          end;
          agregarJugador(l, j);
     end;
end;

procedure crearLista(var l: listaPartidos);
var
   p: partido;
   cant, i: integer;
begin
     cant := random(10);
     for i:=1 to cant do
     begin
          with(p) do begin
               estadio:= Concat('Estadio-', IntToStr(random (500)+1));
               equipoLocal:= Concat('Equipo-', IntToStr(random (200)+1));
               equipoVisitante:= Concat('Equipo-', IntToStr(random (200)+1));
               cargarFecha(fecha);
               jugadores:= nil;
               cargarJugadores(jugadores);
          end;
          agregar(l, p);
     end;
end;



procedure imprimirJugador(j: jugador);
begin
     with (j) do begin
          writeln('Jugador: ', nombreApellido, ' con dni ',dni, ' en posicion: ', posicion, ' y puntaje: ', puntaje);
     end;
end;

procedure imprimirJugadores(l: lista);
begin
     while (l <> nil) do begin
          imprimirJugador(l^.dato);
          l:= l^.sig;
     end;
end;

procedure imprimir(p: partido);
begin
     with (p) do begin
          writeln('');
          writeln('Partido en el ', estadio, ' entre ',equipoLocal, ' y ', equipoVisitante, ' jugado el: ', fecha, ' por los siguientes jugadores: ');
          imprimirJugadores(jugadores);
     end;
end;

procedure imprimirLista(l: listaPartidos);
begin
     while (l <> nil) do begin
          imprimir(l^.dato);
          l:= l^.sig;
     end;
end;

{-----------------------------------------------------------------------------
Insertar de cada jugador la fecha y el puntaje que tuvo en el partido - Modulo
 auxiliar para punto a) }

procedure InsertarFechaYPuntaje(var l:l_partido; fecha:string; puntaje:integer);
var
  aux:l_partido;
begin
   new(aux);
   aux^.dato.fecha := fecha;
   aux^.dato.puntaje := puntaje;

   aux^.sig := l ;
   l := aux;
end;

{--------------------------------------------------------------------------
INSERTAR - Insertar en arbol - Actividad 9 - A)}

procedure Insertar(var a:arbol; d:jugador; fecha:string);
begin
 if(a = nil) then
   begin
    new(a);
    a^.dato.dni := d.dni;
    a^.dato.nombreApellido := d.nombreApellido;
    a^.dato.posicion := d.posicion;
    a^.HI := nil;
    a^.HD := nil;
    a^.dato.partido:=nil;
    InsertarFechaYPuntaje(a^.dato.partido,fecha,d.puntaje);
   end
 else
  if(d.dni < a^.dato.dni) then
    Insertar(a^.hi,d,fecha)
 else
  if(d.dni > a^.dato.dni) then
    Insertar(a^.hd,d,fecha)
 else
   begin
    InsertarFechaYPuntaje(a^.dato.partido,fecha,d.puntaje);
   end;
end;

{------------------------------------------------------------------------------
Modulo para procesar la lista a) }

procedure ProcesarLista(l:listaPartidos; var a:arbol);
var
  auxJ:lista;
begin
 a:=nil;
 while(l <> nil) do
   begin
       auxJ:=l^.dato.jugadores;
       while(auxJ <> nil) do
         begin
             Insertar(a,auxJ^.dato,l^.dato.fecha);
             auxJ := auxJ^.sig;
         end;
       l := l^.sig;
   end;
end;

{-----------------------------------------------------------------------------
Modulo auxiliar para calcular el puntaje total de todos los partidos de un jugador b) }

function totalPuntaje(l: l_partido):integer;
var
  tot:integer;
begin
 tot:=0;
 while(l <> nil) do
   begin
       tot := tot + l^.dato.puntaje;
       l:=l^.sig;
   end;
 totalPuntaje:=tot;
end;

{----------------------------------------------------------------------------
Derecha -> Raiz -> Izquierda---------EnOrden Invertido}
procedure ImprimirDescendente(a: arbol);
begin
 if(a <> nil) then
   begin
     ImprimirDescendente(a^.hd);
     writeln('DNI: ',a^.dato.dni);
     writeln('Nombre Completo: ',a^.dato.nombreApellido);
     writeln('Posicion : ',a^.dato.posicion);
     writeln('Puntaje total: ',totalPuntaje(a^.dato.partido));
     ImprimirDescendente(a^.hi);
   end;
end;

{----------------------------------------------------------------------------
Modulo poda de arbol - cantidad de jugadores en un rango (dni) c) }
function rangoDni(a:arbol; min:integer; max:integer):integer;
begin
 if(a = nil) then
   rangoDni:=0
 else
  if(a^.dato.dni > max) then
    rangoDni:=rangoDni(a^.hi,min,max)
 else
  if(a^.dato.dni < min) then
    rangoDni:=rangoDni(a^.hd,min,max)
 else
    rangoDni:=1 + rangoDni(a^.hd,min,max) + rangoDni(a^.hi,min,max);
end;

{----------------------------------------------------------------------------
Modulo con parametro para encontrar la cantidad de jugadores de la misma posicion d) }
function cantPosicion(a:arbol; p:string):integer;
var
  tot:integer;
begin
 if(a = nil) then
   cantPosicion:=0
 else
  begin
    if(a^.dato.posicion = p) then
      tot:=1
    else
     tot:=0;

    cantPosicion:=tot + cantPosicion(a^.hi,p) + cantPosicion(a^.hd,p);
  end;
end;

var
   l: listaPartidos;
   a:arbol;
   posicion:string;
begin
     Randomize;

     l:= nil;
     crearLista(l); {carga automática de la estructura disponible}
     writeln ('Lista generada: ');
     imprimirLista(l);
     {Completar el programa}
     ProcesarLista(l,a);
     writeln();
     ImprimirDescendente(a);
     writeln();
     writeln('La cantidad de jugadores que se encuentrar dentro del rango de 30.000.000 y 40.000.000 son: ',rangoDni(a,30000000,40000000));
     writeln();
     writeln('Ingresar posicion: ');
     readln(posicion);
     writeln();
     writeln('Cantidad de jugadores que tienen la misma posicion: ',cantPosicion(a,posicion));
     writeln();
     writeln('Fin del programa');
     readln;
end.
