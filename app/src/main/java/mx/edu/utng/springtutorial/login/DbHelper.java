package mx.edu.utng.springtutorial.login;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rodrigo Cortes Armas on 23/03/2016.
 */
public class DbHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    //Nombre de la base de dato
    public static final String DATABASE_NAME = "triviaQuiz";
    // Nombre de la tabla
    public static final String TABLE_NAME_1 = "tbl_usuario";
    public static final String TABLE_NAME_2 = "tbl_tema";
    public static final String NAME = "nombre";
    public static final String PASSWORD = "contrasena";
    public static final String USER_ID = "id_usuario";
    public static final String ACTIVO = "activo";
    public static final String CALIFICACION = "calificacion";
    public static final String ID = "_id";

    // Nombre de la tabla
    private static final String TABLE_QUEST = "quest";
    // nombre de cada una de las columnas
    public static final String KEY_ID = "id";
    public static final String KEY_QUES = "question";
    public static final String KEY_ANSWER = "answer"; //Opcion correcta
    public static final String KEY_OPTA= "opta"; //opcion a
    public static final String KEY_OPTB= "optb"; //opcion b
    public static final String KEY_OPTC= "optc"; //opcion c
    private static SQLiteDatabase dbase;



    private static final String CREATE_TABLE_1 =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_1
                    +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +NAME+" TEXT, "
                    +PASSWORD+" TEXT);";


    private static final String CREATE_TABLE_2 =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_2
                    +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +NAME+" TEXT, "
                    +ACTIVO+" INTEGER, "
                    +CALIFICACION+" INTEGER, "
                    +USER_ID+" INTEGER, FOREIGN KEY("+USER_ID+") REFERENCES "+TABLE_NAME_1+" ("+ID+"));";


    private static final String CREATE_TABLE_QUIZ =
            "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                    + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                    +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";

    //Solo utilizamos el context, nombre de la base y la version.
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Crear la tabla
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_1);
        db.execSQL(CREATE_TABLE_2);
        db.execSQL(CREATE_TABLE_QUIZ);
        dbase=db;
        addQuestions();
        dbase=db;
    }

    public DbHelper open()throws SQLException{
        getWritableDatabase();
        return this;
    }

    //Agregar las preguntas, las separa de 5 por cada capitulo.
    private void addQuestions(){
        Pregunta q1;

        q1 = new Pregunta("¿Que es Spring?",
                "Lenguaje de programación", "Un Framework", "Base de Datos", "Un Framework");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Con que lenguaje trabaja Spring?",
                "C#", "Java", "PHP", "Java");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Spring trabaja con POJO?",
                "No", "Si",
                "Depende", "Si");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Por que Spring es modular?",
                "Utilizas solo la programación que necesitas", "Esta dividida en modulos", "Revisa el codigo secuencialmente", "Utilizas solo la programación que necesitas");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Que forma de conectar a base de datos puedes utilizar con Spring?",
                "Hibernate", "MVC", "SQL", "Hibernate");
        this.addQuestion(q1);

        //Tema 2
        q1 = new Pregunta("¿Como se le conoce también a la inyección de dependencias?",
                "Control de dependencias", "Inyección pura", "Inversión de control", "Inversión de control");
        this.addQuestion(q1);

        q1 = new Pregunta("Que etiqueta UI Component muestra una tabla",
                "PanelGrid", "outputLabel", "messages", "PanelGrid");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Cuál es la finalidad de la inyección de dependencias?",
                "Flujo de código más rapido", "Resumen de código", "Código más desacoplado", "Código más desacoplado");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Que ventajas tiene tener código desacoplado?", "Cambiar dependencias en ejecución",
                "Ejecuta la aplicación más rapido", "No tiene ventajas", "Cambiar dependencias en ejecución");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Cuál es el encargado de inyectar las dependencias a los objetos?",
                "Contenedor de Spring", "Constructor",
                "El IDE", "Contenedor de Spring");
        this.addQuestion(q1);



        //Tema 3
        q1 = new Pregunta("¿Que es un Bean?",
                "Un metodo","Un componente reutilizable","Una variable","Un componente reutilizable");
        this.addQuestion(q1);

        q1 = new Pregunta("Con que etiqueta mandarias el mensaje del inputText" +
                "<h:inputTextarea label=\"Mensaje\"\n" +
                "                       id=\"mensaje\" value=\"#{beanMensaje.mensaje}\"\n" +
                "                       required=\"true\"/>",
                "messages", "<h:message for=\"mensaje\" />", "<h:messages", "<h:message for=\"mensaje\" />");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Que le falta al código \n  id=\"persona\" class=\"info.hcosta.ejemplo.Persona\"?",
                "Constructor","El contenedor","la etiqueta <bean></bean>","la etiqueta <bean></bean>");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Que utiliza el contenedor para gestionar los componentes?", "Inyección de dependencias",
                "Metódos abstractos", "Clases", "Inyección de dependencias");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Cuál es la primera y la ultima fase de un Bean?","Inicio y Fin","Creación y Destrucción","Instanciación y Destrucción","Instanciación y Destrucción");
        this.addQuestion(q1);

        //Tema 4

        q1 = new Pregunta("¿Que se utiliza para almacenar colecciones de objetos?",
                "Metodos", "Paquetes", "Clases e interfaces", "Clases e interfaces");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Cuál es la interfaz mas importante en Spring?",
                "Interfaz collection"
                , "Interfaz de clases", "Interfaz de usuario", "Interfaz collection");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Que es importante tener en cuenta antes usar clases de colecciones?",
                "Ubicación", "Tamaño",
                "Importaciones", "Tamaño");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Cuantos tipos de coleciones ofrece Spring?",
                "5", "1","4", "5");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Cuál es la interfaz mas importante en Spring?",
                "Interfaz collection"
                , "Interfaz de clases", "Interfaz de usuario", "Interfaz collection");
        this.addQuestion(q1);

        //Tema 5
        q1 = new Pregunta("¿Que es Hiberntae? ","Una herramienta de JSF", "Un framework",
                "Es un marco de trabajo para persistencia de datos (en Java).", "Es un marco de trabajo para persistencia de datos (en Java).");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Como permite Hibernate manejar la persistencia de los datos en Java",
                "A traves de Java", "Haciendo abstracción de la base de datos","Usando SQL", "Haciendo abstracción de la base de datos");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Cómo se instala Hibernate?",
                "Descargandolo desde hibernate.com", "Viene preinstalado en los servidores Jboss y Glassfish","Viene acompañado de JSF en su desacarga",
                "viene preinstalado en los servidores Jboss y Glassfish");
        this.addQuestion(q1);

        q1 = new Pregunta("¿Qué lenguaje de consulta utliza Hibernate?",
                "HQL", "SQL","DDL",
                "HQL");
        this.addQuestion(q1);

        q1 = new Pregunta("¿HQL esta oriendado a objetos y comprende nociones como herencia, polinorfismo y asociacion?",
                "Si", "No","En ocasiones",
                "Si");
        this.addQuestion(q1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Borra la tabla si existe
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_1);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_2);
        // Crea la tabla nuevamente
        onCreate(db);
        dbase=db;
    }
    public void addQuestion(Pregunta quest){
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserta nueva fila
        dbase.insert(TABLE_QUEST, null, values);
    }

    //Lista de pregunta con el metodo getAllQuestion, sirve para mostrar 5 preguntas por cada
    // elemento del listView, caso 0 muestra las primeras 5 preguntas y asi sucesivamente.
    //
    public List<Pregunta> getAllQuestion(int dd){

        List<Pregunta> quesList = new ArrayList<Pregunta>();
        String selectQuery="";
        dbase=this.getReadableDatabase();//se abre la base a lectura
        Cursor cursor;
        switch (dd) {
            //en la opcion 0 del listView mostrara las primeras 5 preguntas
            case 0:
                selectQuery = "SELECT  * FROM " + TABLE_QUEST + " where " + KEY_ID + " <6 ";// se crea la query
                cursor = dbase.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Pregunta quest = new Pregunta();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }

                break;
            //En la opcion 0 del listView mostrara las preguntas de la 6 a la 10 pregunta
            case 1:
                selectQuery = "SELECT  * FROM " + TABLE_QUEST + " where " + KEY_ID + " >5 OR " + KEY_ID + " <11 ";// se crea la query
                cursor = dbase.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Pregunta quest = new Pregunta();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }
                break;
            //En la opcion 0 del listView mostrara las preguntas de la 10 a la 15
            case 2:
                selectQuery = "SELECT  * FROM " + TABLE_QUEST + " where " + KEY_ID + " >10 OR " + KEY_ID + " <16 ";// se crea la query
                cursor = dbase.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Pregunta quest = new Pregunta();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }
                break;
            //En la opcion 0 del listView mostrara las preguntas de la 15 a la 20
            case 3:
                selectQuery = "SELECT  * FROM " + TABLE_QUEST + " where " + KEY_ID + " >15 OR " + KEY_ID + " <21 ";// se crea la query
                cursor = dbase.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Pregunta quest = new Pregunta();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }
                break;
            //En la opcion 0 del listView mostrara las preguntas de la 20 a la 25
            case 4:
                selectQuery = "SELECT  * FROM " + TABLE_QUEST + " where " + KEY_ID + " >20 OR " + KEY_ID + " <26 ";// se crea la query
                cursor = dbase.rawQuery(selectQuery, null);//Se hace la consulta
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Pregunta quest = new Pregunta();
                        quest.setID(cursor.getInt(0));
                        quest.setQUESTION(cursor.getString(1));
                        quest.setANSWER(cursor.getString(2));
                        quest.setOPTA(cursor.getString(3));
                        quest.setOPTB(cursor.getString(4));
                        quest.setOPTC(cursor.getString(5));
                        quesList.add(quest);
                    } while (cursor.moveToNext());
                }
                break;
            default:
                break;
        }
        return quesList;
    }
    public int rowcount(){
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }

    public void addTopics(int idUsuario){
        Tema tema;
        dbase=this.getReadableDatabase();
        //Comienza la insercion de los temas
        tema = new Tema("tem_1", idUsuario, true, 0);
        this.addTopic(tema);
        tema = new Tema("tem_2", idUsuario, false, 0);
        this.addTopic(tema);
        tema = new Tema("tem_3", idUsuario, false, 0);
        this.addTopic(tema);
        tema = new Tema("tem_4", idUsuario, false, 0);
        this.addTopic(tema);
        tema = new Tema("tem_5", idUsuario, false, 0);
        this.addTopic(tema);
/*
        String idUsu = String.valueOf(idUsuario);
        int idTemaUno = idTema1(idUsu, "tem_1");
        Log.e("Id del primer tema", "addTopics: " + idTemaUno);
*/

    }

    private void addTopic(Tema tema){
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, tema.getNombre());
        values.put(ACTIVO, tema.isActivo() == true?1:0);
        values.put(CALIFICACION, tema.getCalificacion());
        values.put(USER_ID, tema.getIdUsuario());
        // Inserting Row
        dbase.insert(TABLE_NAME_2, null, values);
    }

    public int[] loginInternoDb(String nomUsu,String contrUsu){
        dbase=this.getReadableDatabase();
        Cursor cursor=dbase.rawQuery(
                "SELECT * FROM " + TABLE_NAME_1 + " WHERE "+NAME+" LIKE ? AND "+PASSWORD+" = ? ", new String[]{nomUsu, contrUsu});
        int[] datosLogeo=new int[2];
        datosLogeo[0]=0;//si esta loeagado
        datosLogeo[1]=0;//id usu
        if (cursor!=null){
            if (cursor.getCount()>0){
                datosLogeo[0]=1;
                cursor.moveToFirst();
                datosLogeo[1]=cursor.getInt(cursor.getColumnIndex(ID));
                return datosLogeo;
            }
        }
        return datosLogeo;
    }
    public int idTema1(int idUsuario, String nombreTema){
        String idUsu=String.valueOf(idUsuario);
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery("SELECT * FROM " +TABLE_NAME_2 + " WHERE nombre LIKE ? AND " +USER_ID + " = ?", new String[]{nombreTema, idUsu});
        int idTem = 0;
        if (cursor != null){
            cursor.moveToFirst();
            idTem = cursor.getInt(cursor.getColumnIndex(USER_ID));
            return idTem;
        } else {
            return idTem;
        }
    }


    public boolean statusTema(int idUsuario, int numTema){
        dbase=this.getReadableDatabase();
        String idUsu=String.valueOf(idUsuario);
        String nomTem="";
        boolean activo=false;
        switch (numTema){
            case 1:
                Log.e("1", "statusTema: TwT" );
                nomTem="tem_1";
                Cursor cursor=dbase.rawQuery(
                        "SELECT * FROM " + TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});
                Log.e("2", "statusTema: TwT" );

                if (cursor!=null){
                    cursor.moveToFirst();
                    activo = cursor.getInt(cursor.getColumnIndex(ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
            case 2:
                nomTem="tem_2";
                Cursor cursor1=dbase.rawQuery(
                        "SELECT * FROM " + TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});

                if (cursor1!=null){
                    cursor1.moveToFirst();
                    activo = cursor1.getInt(cursor1.getColumnIndex(ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
            case 3:
                nomTem="tem_3";
                Cursor cursor2=dbase.rawQuery(
                        "SELECT * FROM " + TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});

                if (cursor2!=null){
                    cursor2.moveToFirst();
                    activo = cursor2.getInt(cursor2.getColumnIndex(ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
            case 4:
                nomTem="tem_4";
                Cursor cursor3=dbase.rawQuery(
                        "SELECT * FROM " + TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});

                if (cursor3!=null){
                    cursor3.moveToFirst();
                    activo = cursor3.getInt(cursor3.getColumnIndex(ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
            case 5:
                nomTem="tem_5";
                Cursor cursor4=dbase.rawQuery(
                        "SELECT * FROM " + TABLE_NAME_2 + " WHERE nombre LIKE ? AND id_usuario=?", new String[]{nomTem, idUsu});

                if (cursor4!=null){
                    cursor4.moveToFirst();
                    activo = cursor4.getInt(cursor4.getColumnIndex(ACTIVO))== 1?true:false;
                    return activo;
                }
                return activo;
           }
        return false;
    }

    public void insertaCalifTemas(int calificacion, int idUsuario, int numTema){
        dbase=this.getReadableDatabase();
        int calif = 0;
        String nombreTema = "";
        ContentValues values = new ContentValues();

        int totalCal = 0;
        if (calificacion == 5){
            totalCal = 10;
        }else if (calificacion == 4){
            totalCal = 8;
        }

        switch (numTema){
            case 1:
                nombreTema = "tem_2";
                break;
            case 2:
                nombreTema = "tem_3";
                break;
            case 3:
                nombreTema = "tem_4";
                break;
            case 4:
                nombreTema = "tem_5";
                break;
            case 5:
                nombreTema = "tem_6";
                break;
            case 6:
                //Mensaje de exito
                break;
        }

        //Falta agregar calificacion!

        if (totalCal >= 8){
            values.put(ACTIVO, true);
        } else {
            values.put(ACTIVO, false);
        }

        //values.put(CALIFICACION, totalCal);
        String idUsu=String.valueOf(idUsuario);
        Log.e("1 de update", "insertaCalifTemas: " );

        dbase.update(TABLE_NAME_2, values, USER_ID + " = ? AND " + NAME + " LIKE ? ", new String[]{idUsu, nombreTema});

        Log.e("2 de update", "insertaCalifTemas: ");
    }

    public int getProgreso(int idUsuario){
        dbase=this.getReadableDatabase();
        int row=0;
        String idUsu=String.valueOf(idUsuario);
        Cursor cursor = dbase.rawQuery("SELECT  * FROM " + TABLE_NAME_2+" where "+ACTIVO+" = ? and "+USER_ID+" = ?",
                new String[]{"1",idUsu});
        row=cursor.getCount();
        return row;

    }

}