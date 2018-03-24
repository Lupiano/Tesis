import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static List<RefactorizacionManual> casosManuales = new ArrayList<RefactorizacionManual>();
	private static int cantidadOp=0;
	
	public static void imprimirListas() {
		for(RefactorizacionManual m: casosManuales) {
			System.out.println("");
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("Caso Manual: " + m.getNombre());		
			List<Clase> c = m.getClases();
			for(Clase cl: c) {
				System.out.println("");
				System.out.println("Clase: " + cl.getClase());
				List<String> op = cl.getOperaciones();
				for(String s: op) {
					System.out.println("Operacion: " + s);
				}
			}

		}
	}
	
	public static void cargarListas(){
		Clase c = new Clase();
		RefactorizacionManual element = new RefactorizacionManual();
		
		element.setNombre("Imeroni");
		
		c.setClase(0);
		c.getOperaciones().add("AltaProveedor");
		c.getOperaciones().add("AltaAcreedor");
		c.getOperaciones().add("BajaProveedor");
		c.getOperaciones().add("BajaAcreedor");
		c.getOperaciones().add("ModificacionProveedor");
		c.getOperaciones().add("ModificacionAcreedor");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);		
		
		c = new Clase();
		c.setClase(1);
		c.getOperaciones().add("AltaVendedor");
		c.getOperaciones().add("AltaCliente");
		c.getOperaciones().add("BajaVendedor");
		c.getOperaciones().add("BajaCliente");
		c.getOperaciones().add("ModificacionVendedor");
		c.getOperaciones().add("ModificacionCliente");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(2);
		c.getOperaciones().add("AltaCheque");
		c.getOperaciones().add("AltaCheque");
		c.getOperaciones().add("BajaCheque");
		c.getOperaciones().add("BajaCheque");
		c.getOperaciones().add("ModificacionCheque");
		c.getOperaciones().add("ModificacionCheque");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(3);
		c.getOperaciones().add("AltaCliente");
		c.getOperaciones().add("AltaOtroDeudor");
		c.getOperaciones().add("BajaCliente");
		c.getOperaciones().add("BajaOtroDeudor");
		c.getOperaciones().add("ModificacionCliente");
		c.getOperaciones().add("ModificacionOtroDeudor");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(4);
		c.getOperaciones().add("AltaTalonario");
		c.getOperaciones().add("AltaReciboProvisorio");
		c.getOperaciones().add("BajaTalonario");
		c.getOperaciones().add("BajaReciboProvisorio");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(5);
		c.getOperaciones().add("ArmarListadosSubsidios");
		c.getOperaciones().add("ArmarListadosSubsidios");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(6);
		c.getOperaciones().add("ObtenerBalanceMayorProveedoresPorCodigoProveedor");
		c.getOperaciones().add("ObtenerBalanceArchivosDiarios");
		c.getOperaciones().add("ObtenerBalanceLibroIva");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(7);
		c.getOperaciones().add("ObtenerBalanceCuentaDeudasYCuentaCorriente");
		c.getOperaciones().add("ObtenerBalanceCuentaDeudasYCuentaCorrienteSalidaExcel");
		c.getOperaciones().add("ObtenerBalanceCuentaDeudasYCuentaCorrienteSalidaAExcel");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(8);
		c.getOperaciones().add("ObtenerBalanceSaldosAcreedoresProveedores");
		c.getOperaciones().add("ObtenerBalanceSaldosClientes");
		c.getOperaciones().add("ObtenerBalanceSaldosClientesSalidaExcel");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(9);
		c.getOperaciones().add("ObtenerBalanceMovimientosCuentasCorrientes");
		c.getOperaciones().add("ObtenerBalanceMovimientosCuentasProveedoresAcreedores");
		c.getOperaciones().add("ObtenerBalanceMovimientosCuentasProveedoresAcreedoresSalidaExcel");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(10);
		c.getOperaciones().add("ControlarSecuenciaLibroIva");
		c.getOperaciones().add("ControlarNumeracionRecibos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(11);
		c.getOperaciones().add("ControlarRecibosProvisorios");
		c.getOperaciones().add("ControlarRecibosProvisorios");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(12);
		c.getOperaciones().add("ControlarRecibosProvisorios");
		c.getOperaciones().add("ControlarRecibosProvisorios");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(13);
		c.getOperaciones().add("ObtenerListadoCuentasCorrientesAcreedores");
		c.getOperaciones().add("ObtenerListadoCuentasCorrientesProveedores");
		c.getOperaciones().add("ObtenerListadoCuentasCorrientesVendedores");
		c.getOperaciones().add("ObtenerListadoCuentasEnGestionJudicial");
		c.getOperaciones().add("ObtenerListadoCuentasOtrosDeudores");
		c.getOperaciones().add("ObtenerListadoCuentasCorrientes");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(14);
		c.getOperaciones().add("RealizarCredito");
		c.getOperaciones().add("RealizarCredito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(15);
		c.getOperaciones().add("EmitirRecibos");
		c.getOperaciones().add("EmitirRecibos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(16);
		c.getOperaciones().add("EntregarMercaderia");
		c.getOperaciones().add("EntregarMercaderia");
		c.getOperaciones().add("EntregarMercaderia");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(17);
		c.getOperaciones().add("ObtenerListadoSubsidios");
		c.getOperaciones().add("ObtenerListadoOnca");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(18);
		c.getOperaciones().add("FacturarPedido");
		c.getOperaciones().add("FacturarPedido");
		c.getOperaciones().add("FacturarPedido");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(19);
		c.getOperaciones().add("ObtenerListadoTelefonos");
		c.getOperaciones().add("ObtenerListadoTelefonos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(20);
		c.getOperaciones().add("ObtenerInformeClientes");
		c.getOperaciones().add("ObtenerInformeClientes");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(21);
		c.getOperaciones().add("ObtenerListadoLibroVentasPorImputacion");
		c.getOperaciones().add("ObtenerListadoLibroVentasPorImputacion");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(22);
		c.getOperaciones().add("LimpiarLibroCompras");
		c.getOperaciones().add("LimpiarLibroRecibos");
		c.getOperaciones().add("LimpiarLibroIva");
		c.getOperaciones().add("LimpiarKardex");
		c.getOperaciones().add("LimpiarEstadisticas");
		c.getOperaciones().add("LimpiarCuentasCorrientes");
		c.getOperaciones().add("LimpiarMercaderiaAEntregarDonaciones");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(23);
		c.getOperaciones().add("ObtenerListadoIngresosEgresos");
		c.getOperaciones().add("ObtenerListadoIngresosEgresos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(24);
		c.getOperaciones().add("ObtenerListadoChequesRechazados");
		c.getOperaciones().add("ObtenerListadoChequesRecibidos");
		c.getOperaciones().add("ObtenerListadoChequesRecibidosSalidaExcel");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(25);
		c.getOperaciones().add("ObtenerListadoDeudoresPorVentasZonaMesSalidaExcel");
		c.getOperaciones().add("ObtenerListadoDeudoresGestionJudicialPorZonaMesSalidaExcel");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(26);
		c.getOperaciones().add("ObtenerListadoFacturacion");
		c.getOperaciones().add("ObtenerListadoFacturacion");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(27);
		c.getOperaciones().add("ObtenerListadoLibroIva");
		c.getOperaciones().add("ObtenerListadoLibroIva");
		c.getOperaciones().add("ObtenerListadoLibroIva");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(28);
		c.getOperaciones().add("ObtenerListadoAcreedores");
		c.getOperaciones().add("ObtenerListadoClientes");
		c.getOperaciones().add("ObtenerListadoClientes");
		c.getOperaciones().add("ObtenerListadoProveedores");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(29);
		c.getOperaciones().add("ObtenerListadoCuentaCorrienteBolsas");
		c.getOperaciones().add("ObtenerListadoCuentaAcreedores");
		c.getOperaciones().add("ObtenerListadoCuentaAcreedores");
		c.getOperaciones().add("ObtenerListadoCuentaCorrientes");
		c.getOperaciones().add("ObtenerListadoCuentaCorrientesEnGestionJudicial");
		c.getOperaciones().add("ObtenerListadoCuentaProveedores");
		c.getOperaciones().add("ObtenerListadoCuentaVendedores");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(30);
		c.getOperaciones().add("ObtenerListadoDeudas");
		c.getOperaciones().add("ObtenerListadoDeudas");
		c.getOperaciones().add("ObtenerListadoDeudas");
		c.getOperaciones().add("ObtenerListadoDeudas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(31);
		c.getOperaciones().add("ObtenerListadoDeudasChequesRechazados");
		c.getOperaciones().add("ObtenerListadoDeudasChequesRechazados");
		c.getOperaciones().add("ObtenerListadoDeudasChequesRechazadosCartaReclamo");
		c.getOperaciones().add("ObtenerListadoDeudasChequesRechazadosCartaReclamo");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(32);
		c.getOperaciones().add("ObtenerListadoEstadisticas");
		c.getOperaciones().add("ObtenerListadoEstadisticas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(33);
		c.getOperaciones().add("ObtenerListadoLibroIva");
		c.getOperaciones().add("ObtenerListadoLibroIva");
		c.getOperaciones().add("ObtenerListadoLibroIva");
		c.getOperaciones().add("ObtenerListadoLibroIva");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(34);
		c.getOperaciones().add("ObtenerListadoDeudores");
		c.getOperaciones().add("ObtenerListadoDeudores");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(35);
		c.getOperaciones().add("ObtenerListadoMercaderiaAEntregar");
		c.getOperaciones().add("ObtenerListadoMercaderiaAEntregar");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(36);
		c.getOperaciones().add("RealizarNotaCredito");
		c.getOperaciones().add("RealizarNotaDebito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(37);
		c.getOperaciones().add("ObtenerListadoPedidosPendientes");
		c.getOperaciones().add("ObtenerPedidosPendientes");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(38);
		c.getOperaciones().add("ArmarSicorePercepcionesIngresosBrutos");
		c.getOperaciones().add("ArmarSicoreRetenciones");
		c.getOperaciones().add("ArmarSicoreReteneciones");
		c.getOperaciones().add("AcoplarASicore");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(39);
		c.getOperaciones().add("ObtenerListadoVentasPorZona");
		c.getOperaciones().add("ObtenerListadoVentasPorZonaSubproductosMesSalidaExcel");
		c.getOperaciones().add("ObtenerListadoVentasPorZonaSubproductosMesSalidaExcelDetalle");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(40);
		c.getOperaciones().add("AltaRecibo");
		c.getOperaciones().add("BajaRecibo");
		c.getOperaciones().add("ModificacionRecibo");
		c.getOperaciones().add("AltaCreditoReciboInterrumpido");
		c.getOperaciones().add("BajaCreditoReciboInterrumpido");
		c.getOperaciones().add("ModificacionCreditoReciboInterrumpido");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(41);
		c.getOperaciones().add("AnularMercaderia");
		c.getOperaciones().add("AnularFactura");
		c.getOperaciones().add("AnularRecibo");
		c.getOperaciones().add("AnularRemito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(42);
		c.getOperaciones().add("ObtenerListadoCobranzasPorZona");
		c.getOperaciones().add("ObtenerListadoCobranzasPorZona");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(43);
		c.getOperaciones().add("FacturarPedido");
		c.getOperaciones().add("FacturarPedido");
		c.getOperaciones().add("FacturarPedido");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(44);
		c.getOperaciones().add("ObtenerListadoPreciosPromedios");
		c.getOperaciones().add("ObtenerListadoPreciosPromedios");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(45);
		c.getOperaciones().add("AltaArticulo");
		c.getOperaciones().add("BajaArticulo");
		c.getOperaciones().add("ModificacionArticulo");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(46);
		c.getOperaciones().add("AltaComision");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(47);
		c.getOperaciones().add("AltaCompraSinInventario");
		c.getOperaciones().add("BajaCompraSinInventario");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(48);
		c.getOperaciones().add("AltaCondicion");
		c.getOperaciones().add("BajaCondicion");
		c.getOperaciones().add("ModificacionCondicion");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(49);
		c.getOperaciones().add("AltaTelefono");
		c.getOperaciones().add("BajaTelefono");
		c.getOperaciones().add("ConsultaTelefono");
		c.getOperaciones().add("ModificacionTelefono");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(50);
		c.getOperaciones().add("AltaFlete");
		c.getOperaciones().add("BajaFlete");
		c.getOperaciones().add("ModificacionFlete");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(51);
		c.getOperaciones().add("AltaMensaje");
		c.getOperaciones().add("BajaMensaje");
		c.getOperaciones().add("ModificacionMensaje");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(52);
		c.getOperaciones().add("AltaPedidos");
		c.getOperaciones().add("BajaPedidos");
		c.getOperaciones().add("ModificacionPedidos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(53);
		c.getOperaciones().add("AltaInterdeposito");
		c.getOperaciones().add("BajaInterdeposito");
		c.getOperaciones().add("UtilizacionInterdeposito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(54);
		c.getOperaciones().add("AcreditarComision");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(55);
		c.getOperaciones().add("AltaDevolucionBolsa");
		c.getOperaciones().add("BajaDevolucionBolsa");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(56);
		c.getOperaciones().add("AnalizarSituacionZonasDeVenta");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(57);
		c.getOperaciones().add("ArmarArchivosComunicacion");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(58);
		c.getOperaciones().add("ArmarCitiCompras");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(59);
		c.getOperaciones().add("ArmarRegistroRetenciones");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(60);
		c.getOperaciones().add("DarBajaCheque");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(61);
		c.getOperaciones().add("BajaIngreso");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(62);
		c.getOperaciones().add("BajaOrdenPago");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(63);
		c.getOperaciones().add("ObtenerBalanceCuentasCorrientesGestionJudicial");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(64);
		c.getOperaciones().add("ObtenerBalanceDeudasCuentasCorrientes");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(65);
		c.getOperaciones().add("ObtenerBalanceEntreCuentasCorrientesYArrastreSaldo");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(66);
		c.getOperaciones().add("ObtenerListadoMovimientosRepetidosMercaderiaAEntregar");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(67);
		c.getOperaciones().add("AltaCaja");
		c.getOperaciones().add("BajaCaja");
		c.getOperaciones().add("ModificacionCaja");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(68);
		c.getOperaciones().add("GenerarListadoCheques");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(69);
		c.getOperaciones().add("ComplementarRecibos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(70);
		c.getOperaciones().add("ObtenerListadoMercaderiaAEntrengar");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(71);
		c.getOperaciones().add("ConvertirPadronIngresosBrutos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(72);
		c.getOperaciones().add("RealizarCredito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(73);
		c.getOperaciones().add("CruzarTotalesMovimientos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(74);
		c.getOperaciones().add("ContarBolsas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(75);
		c.getOperaciones().add("RealizarDeposito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(76);
		c.getOperaciones().add("ObtenerListadoDescuentos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(77);
		c.getOperaciones().add("ObtenerDetalleRetencionesOrdenesPago");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(78);
		c.getOperaciones().add("ObtenerListadoDeudas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(79);
		c.getOperaciones().add("ObtenerListadoDeudores");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(80);
		c.getOperaciones().add("DevolverPedido");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(81);
		c.getOperaciones().add("ObtenerListadoDuplicadoOrdenesPago");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(82);
		c.getOperaciones().add("EmitirCartaPorte");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(83);
		c.getOperaciones().add("EmitirConFacturaDeCredito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(84);
		c.getOperaciones().add("EmitirCreditosCobranza");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(85);
		c.getOperaciones().add("EmitirOrdenPagoYComprobanteRetencion");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(86);
		c.getOperaciones().add("EndosarCheque");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(87);
		c.getOperaciones().add("FacturarFlete");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(88);
		c.getOperaciones().add("FacturarPedido");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(89);
		c.getOperaciones().add("GenerarArchivoDgi");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(90);
		c.getOperaciones().add("ImprimirCarteraInterdepositos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(91);
		c.getOperaciones().add("ObtenerListadoCuentasOtroDeudores");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(92);
		c.getOperaciones().add("ObtenerListadoFacturaCredito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(93);
		c.getOperaciones().add("ObtenerListadoLibroBancos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(94);
		c.getOperaciones().add("ObtenerListadoLibroCartasPorteEmitidas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(95);
		c.getOperaciones().add("ObtenerListadoLibroOrdenesPago");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(96);
		c.getOperaciones().add("ObtenerListadoTotalesMovimientosStockMensual");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(97);
		c.getOperaciones().add("ObtenerListadoCarteraDocumentosACobrar");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(98);
		c.getOperaciones().add("AjustarStock");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(99);
		c.getOperaciones().add("ObtenerListadoLibroComprasPorImputacion");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(100);
		c.getOperaciones().add("LiquidarComisionVendedores");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(101);
		c.getOperaciones().add("ObtenerListadoContabilizaBorraCaja");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(102);
		c.getOperaciones().add("ObtenerListadoDeudas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(103);
		c.getOperaciones().add("ObtenerListadoCajaOrdenMayor");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(104);
		c.getOperaciones().add("ObtenerListadoComisionesPorVendedorMesSalidaExcel");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(105);
		c.getOperaciones().add("ObtenerListadoHarinaVendida");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(106);
		c.getOperaciones().add("ObtenerListadoHistoriaCobranzas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(107);
		c.getOperaciones().add("ObtenerListadoMovimientos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(108);
		c.getOperaciones().add("ObtenerListadoNotasDebitoCredito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(109);
		c.getOperaciones().add("ObtenerListadoNuevoLibroIva");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(110);
		c.getOperaciones().add("ObtenerListadoRecibos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(111);
		c.getOperaciones().add("ObtenerListadoPercepcionesLibroIva");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(112);
		c.getOperaciones().add("ObtenerListadoTotalesCObranzaMensual");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(113);
		c.getOperaciones().add("ObtenerListadoTotalesLibroIva");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(114);
		c.getOperaciones().add("ObtenerListadoHischeq");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(115);
		c.getOperaciones().add("ObtenerListaKardex");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(116);
		c.getOperaciones().add("ObtenerListadoMayor");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(117);
		c.getOperaciones().add("ObtenerListadoSaldosPedidos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(118);
		c.getOperaciones().add("ObtenerListadoSituacionTrigo");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(119);
		c.getOperaciones().add("ModificarArrastreCaja");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(120);
		c.getOperaciones().add("ModificarComision");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(121);
		c.getOperaciones().add("ObtenerListadoMovimientosCliente");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(122);
		c.getOperaciones().add("ObtenerListadoPagado");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(123);
		c.getOperaciones().add("LiquidarOrdenPago");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(124);
		c.getOperaciones().add("ObtenerListadoTalonariosEntregados");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(125);
		c.getOperaciones().add("TransferirImporte");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(126);
		c.getOperaciones().add("ObtenerListadoUnidadEntregadasPorZona");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(127);
		c.getOperaciones().add("VerificarEstadoArchivoFacturacion");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(128);
		c.getOperaciones().add("VerificarCuit");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(129);
		c.getOperaciones().add("VerificarPadronIngresosBrutos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		System.out.println("");
		System.out.println("Cantidad de Operaciones Imeroni: " + cantidadOp);
		System.out.println("");
		System.out.println("---------------------------------------------------------------------------");
		
		casosManuales.add(element);
		//-----------------------------------------------------------------------------------------
		
		cantidadOp = 0;
		c = new Clase();
		element = new RefactorizacionManual();
		element.setNombre("Malavolta");
		c.setClase(0);
		c.getOperaciones().add("prueba1");
		c.getOperaciones().add("prueba2");
		c.getOperaciones().add("prueba3");
		c.getOperaciones().add("prueba4");
		c.getOperaciones().add("prueba5");
		c.getOperaciones().add("prueba6");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);;
		
		System.out.println("");
		System.out.println("Cantidad de Operaciones Malavolta: " + cantidadOp);
		
		casosManuales.add(element);
		//------------------------------------------------------------------------------------------
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cargarListas();
		imprimirListas();
	}
}
