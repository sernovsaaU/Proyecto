package com.sr.sreclamo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sr.sreclamo.entity.reclamoEnti;
import com.sr.sreclamo.model.cliente;
import com.sr.sreclamo.model.estado;
import com.sr.sreclamo.model.marca;
import com.sr.sreclamo.model.producto;
import com.sr.sreclamo.model.reclamo;
import com.sr.sreclamo.model.tipo_fruta;
import com.sr.sreclamo.repo.reclamoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class reclamoService {
    @Autowired
    private reclamoRepo repoR;
    @Autowired
    private frutaService FS;
    @Autowired
    private clienteService CS;
    @Autowired
    private estadoService ES;
    @Autowired
    private productoService PS;
    @Autowired
    private marcaService MS;


    public List<reclamo> listAllReclamos(){
        return repoR.findAll();
    }

    //cambio reclamo por void y se quita return
    public void guardaReclamo(reclamo R){
        System.out.println("codigo interno:" + R.getCodigo_Interno_Reclamo());
        System.out.println("Detalle:" + R.getDetalle_Reclamo());
        System.out.println("codigo interno:" + R.getFecha_Recepcion_Reclamo());        
        R.getClienteIdCliente();
        repoR.save(R);
    }

    public reclamo buscarReclamoPOrID(reclamo R){
        return repoR.getById(R.getNumero_Reclamo());
    }

    public void modificar(){}

    public List<reclamo> multiBusquedaReclamos(Integer entregaX,Integer entregaX2){
        return repoR.busquedaCompleja(entregaX,entregaX2);
    }
    /* 
    public List<reclamo> multiBusquedaReclamos(String entregaX,String entregaX2){
        return repoR.busquedaCompleja(entregaX,entregaX2);
    }
    */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    public List<reclamo> buscaConP(reclamo consulta){
        
        Date FRRP=null;
        String FRR=null;

        Date FRCP=null;
        String FRC=null;
        
        if(consulta.getFecha_Recepcion_Reclamo()!=null){
            FRCP=consulta.getFecha_Recepcion_Reclamo();
            System.out.print(FRCP);
            System.out.println("Sale formato recepcion: "+FRCP);

            SimpleDateFormat sdfc = new SimpleDateFormat("yyyy-MM-dd");
            FRC = sdfc .format(FRCP);
            System.out.println(FRC);
        }

        if(consulta.getFecha_Respuesta_Reclamo()!=null){
            FRRP=consulta.getFecha_Respuesta_Reclamo();
            System.out.print(FRRP);
            System.out.println("Sale formato respuesta: "+FRRP);

            SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd");
            FRR = sdfr.format(FRRP);
            System.out.println(FRR);
        }
        Integer N=consulta.getNumero_Reclamo();

        Integer CIR = consulta.getCodigo_Interno_Reclamo();
        
        Integer TRR1=consulta.getTemporada_Proceso_Reclamo_1();
        Integer TRR2=consulta.getTemporada_Proceso_Reclamo_2();
        
        Integer TPR1=consulta.getTemporada_Proceso_Reclamo_1();
        Integer TPR2=consulta.getTemporada_Proceso_Reclamo_2();
        Integer EI=consulta.getEstado_Id_estado();
        Integer I=consulta.getInvestigacion_Id_Investigacion();
        Integer TPI=consulta.getTipo_Producto_Id_Producto();
        Integer MI=consulta.getMarca_Id_Marca();
        Integer TFI=consulta.getTipo_Fruta_Id_Tipo_Fruta();
        Integer CI=consulta.getClienteIdCliente();
        Integer STCRI=consulta.getClienteIdCliente();
        
        return repoR.consultaMParam(N,CIR,FRC,TRR1,TRR2,FRR,TPR1,TPR2,EI,I,TPI,MI,TFI,CI,STCRI);
    }   

    public List<reclamoEnti> modelToEntity(List<reclamo> lista){
        List<reclamoEnti> entidades= new ArrayList<reclamoEnti>();
        for (int i = 0; i < lista.size(); i++) {
            //System.out.println("El tamaño es: "+lista.size() +"valor i del for: " + i);
            
            Integer buscaConEsteId=lista.get(i).getTipo_Fruta_Id_Tipo_Fruta();
            
            //System.out.println("El idfruta es: "+buscaConEsteId);
            tipo_fruta f=FS.buscarNombreConId(buscaConEsteId);
            //System.out.println("Fruta obetenida:" + f.getNombre_Tipo_Fruta());

            buscaConEsteId=lista.get(i).getClienteIdCliente();
            cliente c=CS.buscarNombreConId(buscaConEsteId);
            //System.out.println("Cliente obetenido: " + c.getNombreCliente());

            buscaConEsteId=lista.get(i).getEstado_Id_estado();
            estado e=ES.buscarNombreConId(buscaConEsteId);
            //System.out.println("Estado obetenida"+ e.getEstado());

            buscaConEsteId=lista.get(i).getTipo_Producto_Id_Producto();
            producto p=PS.buscarNombreConId(buscaConEsteId);
            //System.out.println("Producto obetenida"+ e.getEstado());

            buscaConEsteId=lista.get(i).getMarca_Id_Marca();
            marca m=MS.buscarNombreConId(buscaConEsteId);
            //System.out.println("Marca obetenida"+ e.getEstado());

            reclamoEnti nuevaEntidad=new reclamoEnti(lista.get(i),f,c,e,p,m);
   
            entidades.add(nuevaEntidad);
            //System.out.println("Entidad asginada a lista");
           
        }
        System.out.println("Control de salida");
        return entidades;
    }

    public long cantidadR(){
        long r=repoR.count();
        return r;

    }

    public reclamoEnti oneModelToEntity(reclamo lista){
        
        
        Integer buscaConEsteId=lista.getTipo_Fruta_Id_Tipo_Fruta();
        tipo_fruta f=FS.buscarNombreConId(buscaConEsteId);
        
        buscaConEsteId=lista.getClienteIdCliente();
        cliente c=CS.buscarNombreConId(buscaConEsteId);
        //System.out.println("Cliente obetenido: " + c.getNombreCliente());

        buscaConEsteId=lista.getEstado_Id_estado();
        estado e=ES.buscarNombreConId(buscaConEsteId);
        //System.out.println("Estado obetenida"+ e.getEstado());

        buscaConEsteId=lista.getTipo_Producto_Id_Producto();
        producto p=PS.buscarNombreConId(buscaConEsteId);
        //System.out.println("Producto obetenida"+ e.getEstado());

        buscaConEsteId=lista.getMarca_Id_Marca();
        marca m=MS.buscarNombreConId(buscaConEsteId);
        //System.out.println("Marca obetenida"+ e.getEstado());

        reclamoEnti nuevaEntidad= new reclamoEnti(lista,f,c,e,p,m);
        
        return nuevaEntidad;
    }

    public reclamoEnti formar(Integer id){
        reclamo F=repoR.getById(id);
        reclamoEnti nuevo=oneModelToEntity(F);
        return nuevo;
    }
  
    @Transactional
    public void update(reclamo consulta){
        Date FRRP=null;
        String FRR=null;

        Date FRCP=null;
        String FRC=null;
        
        if(consulta.getFecha_Recepcion_Reclamo()!=null){
            FRCP=consulta.getFecha_Recepcion_Reclamo();
            System.out.print(FRCP);
            System.out.println("Sale formato recepcion: "+FRCP);

            SimpleDateFormat sdfc = new SimpleDateFormat("yyyy-MM-dd");
            FRC = sdfc .format(FRCP);
            System.out.println(FRC);
        }

        if(consulta.getFecha_Respuesta_Reclamo()!=null){
            FRRP=consulta.getFecha_Respuesta_Reclamo();
            System.out.print(FRRP);
            System.out.println("Sale formato respuesta: "+FRRP);

            SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd");
            FRR = sdfr.format(FRRP);
            System.out.println(FRR);
        }
        Integer N=consulta.getNumero_Reclamo();
        String DR=consulta.getDetalle_Reclamo();
        Integer CIR = consulta.getCodigo_Interno_Reclamo();
        
        Integer TRR1=consulta.getTemporada_Proceso_Reclamo_1();
        Integer TRR2=consulta.getTemporada_Proceso_Reclamo_2();
        
        Integer TPR1=consulta.getTemporada_Proceso_Reclamo_1();
        Integer TPR2=consulta.getTemporada_Proceso_Reclamo_2();
        Integer EI=consulta.getEstado_Id_estado();
        Integer I=consulta.getInvestigacion_Id_Investigacion();
        Integer TPI=consulta.getTipo_Producto_Id_Producto();
        Integer MI=consulta.getMarca_Id_Marca();
        Integer TFI=consulta.getTipo_Fruta_Id_Tipo_Fruta();
        Integer CI=consulta.getClienteIdCliente();
        Integer STCRI=consulta.getClienteIdCliente();
        System.out.println("Control de entrada");
        try {
            repoR.update(DR, FRC, TRR1, TRR2, FRR, TPR1, TPR2, EI, I, TPI, MI, TFI, CI, STCRI,N,CIR); 
            System.out.print("Thus cachestes");
        } catch (Exception e) {
            System.out.print("Thus Error"+e);
        }
        
       
    }
    /*
    public List<reclamo> busquedaConPar(String entregaX,String entregaX2){
        return repoR.busquedaCompleja(entregaX,entregaX2);
    }*/

}
