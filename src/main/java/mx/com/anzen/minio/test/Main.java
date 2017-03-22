package mx.com.anzen.minio.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.Result;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import mx.com.anzen.minio.bean.Archivo;
import mx.com.anzen.minio.bean.PrincipalBean;
import mx.com.anzen.minio.config.AppConfig;
import mx.com.anzen.minio.config.Conexion;
import mx.com.anzen.minio.imple.Operaciones;
import mx.com.anzen.minio.interfaces.IOperaciones;

public class Main {

	 
	public static void main(String[] args) {
		
		
		ApplicationContext appContext=null;
		IOperaciones beanPrincipal=null;
		
		appContext=new AnnotationConfigApplicationContext(AppConfig.class);
		beanPrincipal=(IOperaciones) appContext.getBean("coreConfig");
		
		
		//verifica si existe el nodo dado
		boolean resultado=beanPrincipal.existeNodo("anzen");
		System.out.println("resultado  "+resultado);
		 
		// valida si existe el nodo si no existe lo crea sube el archivo y nos genera la url dandole el tiempo de vida dada.
//		String url2=beanPrincipal.crearUrl("banca", "/home/anzen/Escritorio/anzen-minio-1.0.jar", 30); 
//		System.out.println(url2);
		
		
		//nos trae el listado de los archivo de un nodo dado
//		ArrayList<Archivo> listaOb= beanPrincipal.listaArchivos("banca");  
//			for(int i=0;i<listaOb.size();i++){
//				System.out.println("nombre del archivo "+listaOb.get(i).getNombreArchivo()+"------------- fecha de creacion "+listaOb.get(i).getFecha());
//			}
		
		
		// nos genera la url usando el metodo put
		 
//		String url= beanPrincipal.generaUrlPut("rey","anzen.jpg",30);
//		System.out.println(url);
	
		 
		//nos genera una url del archivo usando el metodo get
//		String url1= beanPrincipal.generaUrl("rey","anzen.jpg",20);
//		System.out.println(url1);
		
		 
		
		
		 
		 
		//nos trae todos los nodos que existen
//		List<Bucket> lista= beanPrincipal.listaNodos();
//		for (Bucket bucket : lista) {
//	        System.out.println(bucket.creationDate() + ", " + bucket.name());
//	      }
		
		
		 // nos trae las propiedades de un archivo dando el nombre y el nodo donde se encuentra
//		ObjectStat object= beanPrincipal.datosArchivo("banca","anzen.jpg"); 
//		System.out.println("nodo alm "+object.bucketName()+"\ntipo archivo "+object.contentType()+"\nnombre arch  " +object.name()+"\nfecha creacion "+object.createdTime());
		
		 
		// nos permite subir el archivo 
//		String resultadosubir=beanPrincipal.subirArchivo("docker","/home/anzen/Escritorio/anzen.jpg");
//		System.out.println(resultadosubir);
		 
		 
		
		//nos crea un nodo
//		String resultadoNodo= beanPrincipal.crearNodo("anzen"); 
//		System.out.println("resss "+resultadoNodo);
		
		//Elimina el nodo dando el nombre
//		String resultadoNodoeli= beanPrincipal.eliminaNodo("anzen");
//		System.out.println("resss "+resultadoNodoeli);
		
		//Elimina un archivo
//		String resultadoeliArchivo=beanPrincipal.eliminaArchivo("anzen","anzen.jpg" );
//		System.out.println(resultadoeliArchivo);
		
		
		System.out.println("end");
		
		((ConfigurableApplicationContext) appContext).close();
		 
		 
	 
		
	}

}
