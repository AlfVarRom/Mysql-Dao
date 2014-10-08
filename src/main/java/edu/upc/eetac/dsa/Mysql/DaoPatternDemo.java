package edu.upc.eetac.dsa.Mysql;



public class DaoPatternDemo {
	
		public static void main(String[] args) throws Exception {
		   
		 StudentDao studentDao = new StudentDaoImpl();//Objeto para realizar operaciones
		 boolean eliminar;
		 
	     eliminar=studentDao.deleteStudent(new Student("Victor"));//Variable booleana que comprueba la operaciÃ³n de eliminado
		 
	     if (eliminar==true){
		    	 System.out.println("Eliminado estudiante correctamente");
		     }else {
		    	 System.out.println("No se encuentra estudiante en la BBDD");
		 }
	     
		 Student buscar = studentDao.getStudent("Machado");
		 
		 if (buscar==null){
			 System.out.println("No se encuentra estudiante en la BBDD");
		 }else
			 System.out.println(buscar.getName());
	     
	    }
}

