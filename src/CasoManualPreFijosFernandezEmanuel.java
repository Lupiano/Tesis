import java.util.ArrayList;
import java.util.List;

public class CasoManualPreFijosFernandezEmanuel {
	private List<RefactorizacionManual> casosManuales = new ArrayList<RefactorizacionManual>();
	private int cantidadOp=0;
	
	public List<RefactorizacionManual> getCasosManuales() {
		return casosManuales;
	}

	public void setCasosManuales(List<RefactorizacionManual> casosManuales) {
		this.casosManuales = casosManuales;
	}
	
	public void imprimirListas() {
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
	
	public void cargarListas(){
		Clase c = new Clase();
		RefactorizacionManual element = new RefactorizacionManual();
		
		/*
			
		
		c = new Clase();
		c.setClase(2);
		c.getOperaciones().add("AbmChequesRechazados_AltaCheque");
		c.getOperaciones().add("AbmChequesEnCartera_AltaCheque");
		c.getOperaciones().add("AbmChequesRechazados_BajaCheque");
		c.getOperaciones().add("AbmChequesEnCartera_BajaCheque");
		c.getOperaciones().add("AbmChequesRechazados_ModificacionCheque");
		c.getOperaciones().add("AbmChequesEnCartera_ModificacionCheque");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		
		c = new Clase();
		c.setClase(5);
		c.getOperaciones().add("ArmadoListadoSubsidios_ArmarListadosSubsidios");
		c.getOperaciones().add("ArmadoListadoSubsidiosSalidaExcel_ArmarListadosSubsidios");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(6);
		c.getOperaciones().add("BalanceMayorProveedoresPorCodigoProveedor_ObtenerBalanceMayorProveedoresPorCodigoProveedor");
		c.getOperaciones().add("BalanceArchivosDiarios_ObtenerBalanceArchivosDiarios");
		c.getOperaciones().add("BalanceLibroIva_ObtenerBalanceLibroIva");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(7);
		c.getOperaciones().add("BalanceCuentaDeudasYCuentaCorriente_ObtenerBalanceCuentaDeudasYCuentaCorriente");
		c.getOperaciones().add("BalanceCuentaDeudasYCuentaCorrienteSalidaExcel_ObtenerBalanceCuentaDeudasYCuentaCorrienteSalidaExcel");
		c.getOperaciones().add("BalanceCuentaDeudasYCuentaCorrienteSalidaAExcel_ObtenerBalanceCuentaDeudasYCuentaCorrienteSalidaAExcel");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(8);
		c.getOperaciones().add("BalanceSaldosAcreedoresProveedores_ObtenerBalanceSaldosAcreedoresProveedores");
		c.getOperaciones().add("BalanceSaldosClientes_ObtenerBalanceSaldosClientes");
		c.getOperaciones().add("BalanceSaldosClientesSalidaExcel_ObtenerBalanceSaldosClientesSalidaExcel");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(9);
		c.getOperaciones().add("BalanceMovimientosCuentasCorrientes_ObtenerBalanceMovimientosCuentasCorrientes");
		c.getOperaciones().add("BalanceMovimientosCuentasProveedoresAcreedores_ObtenerBalanceMovimientosCuentasProveedoresAcreedores");
		c.getOperaciones().add("BalanceMovimientosCuentasProveedoresAcreedoresSalidaExcel_ObtenerBalanceMovimientosCuentasProveedoresAcreedoresSalidaExcel");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(10);
		c.getOperaciones().add("ControlSecuenciaLibroIva_ControlarSecuenciaLibroIva");
		c.getOperaciones().add("ControlNumeracionRecibos_ControlarNumeracionRecibos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(11);
		c.getOperaciones().add("ControlRecibosProvisoriosEnviadosRecibidos_ControlarRecibosProvisorios");
		c.getOperaciones().add("ControlRecibosProvisoriosEnviadosRecibidosSalidaExcel_ControlarRecibosProvisorios");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(12);
		c.getOperaciones().add("ControlRecibosProvisoriosRecibidos_ControlarRecibosProvisorios");
		c.getOperaciones().add("ControlRecibosProvisoriosRecibidosSalidaExcel_ControlarRecibosProvisorios");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(13);
		c.getOperaciones().add("ControlRecibosProvisoriosRecibidosSalidaExcel_ObtenerListadoCuentasCorrientesAcreedores");
		c.getOperaciones().add("CuentasCorrientesProveedoresPorPantalla_ObtenerListadoCuentasCorrientesProveedores");
		c.getOperaciones().add("CuentasCorrientesVendedoresPorPantalla_ObtenerListadoCuentasCorrientesVendedores");
		c.getOperaciones().add("CuentasEnGestionJudicialPorPantalla_ObtenerListadoCuentasEnGestionJudicial");
		c.getOperaciones().add("CuentasOtrosDeudoresPorPantalla_ObtenerListadoCuentasOtrosDeudores");
		c.getOperaciones().add("CuentasCorrientesPorPantalla_ObtenerListadoCuentasCorrientes");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(14);
		c.getOperaciones().add("DebitosCreditosCompraCereal_RealizarCredito");
		c.getOperaciones().add("DebitosCreditosVarios_RealizarCredito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(15);
		c.getOperaciones().add("EmisionRecibos_EmitirRecibos");
		c.getOperaciones().add("EmisionRecibosCobroDeudores_EmitirRecibos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(16);
		c.getOperaciones().add("EntregaMercaderiaSinFacturaConPedido_EntregarMercaderia");
		c.getOperaciones().add("EntregaMercaderiaSinFacturaConPedidoParaExportacion_EntregarMercaderia");
		c.getOperaciones().add("EntregaMercaderiaSinFacturaNiPedido_EntregarMercaderia");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(17);
		c.getOperaciones().add("ExcelParaSubsidios_ObtenerListadoSubsidios");
		c.getOperaciones().add("ExcelParaInformeOnca_ObtenerListadoOnca");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(18);
		c.getOperaciones().add("FacturacionPedidosSinEntregaMercaderia_FacturarPedido");
		c.getOperaciones().add("FacturacionPedidosSinEntregaMercaderiaExportación_FacturarPedido");
		c.getOperaciones().add("FacturacionPedidos_FacturarPedido");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(19);
		c.getOperaciones().add("ImpresionArchivoTelefono_ObtenerListadoTelefonos");
		c.getOperaciones().add("ImpresionArchivoTelefonoSalidaExcel_ObtenerListadoTelefonos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(20);
		c.getOperaciones().add("InformeClientesParaSecretariaComercio_ObtenerInformeClientes");
		c.getOperaciones().add("InformeClientesParaSecretariaComercioHarina000_ObtenerInformeClientes");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(21);
		c.getOperaciones().add("LibroVentasPorImputacionAPedido_ObtenerListadoLibroVentasPorImputacion");
		c.getOperaciones().add("LibroVentasPorImputacionAPedidoSalidaExcel_ObtenerListadoLibroVentasPorImputacion");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(22);
		c.getOperaciones().add("LimpiezaLibroCompras_LimpiarLibroCompras");
		c.getOperaciones().add("LimpiezaLibroRecibos_LimpiarLibroRecibos");
		c.getOperaciones().add("LimpiezaLibroIva_LimpiarLibroIva");
		c.getOperaciones().add("LimpiezaKardex_LimpiarKardex");
		c.getOperaciones().add("LimpiezaEstadisticas_LimpiarEstadisticas");
		c.getOperaciones().add("LimpiezaCuentasCorrientes_LimpiarCuentasCorrientes");
		c.getOperaciones().add("LimpiaMercaderiaAEntregarDonaciones_LimpiarMercaderiaAEntregarDonaciones");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(24);
		c.getOperaciones().add("ListadoChequesRechazados_ObtenerListadoChequesRechazados");
		c.getOperaciones().add("ListadoChequesRecibidos_ObtenerListadoChequesRecibidos");
		c.getOperaciones().add("ListadoChequesRecibidosSalidaExcel_ObtenerListadoChequesRecibidosSalidaExcel");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(25);
		c.getOperaciones().add("ListadoDeudoresPorVentasZonaMesSalidaExcel_ObtenerListadoDeudoresPorVentasZonaMesSalidaExcel");
		c.getOperaciones().add("ListadoDeudoresGestionJudicialPorZonaMesSalidaExcel_ObtenerListadoDeudoresGestionJudicialPorZonaMesSalidaExcel");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(26);
		c.getOperaciones().add("ListadoFacturadoClienteEntreFechasAPedido_ObtenerListadoFacturacion");
		c.getOperaciones().add("ListadoFacturadoClienteEntreFechasAPedidoSalidaExcel_ObtenerListadoFacturacion");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(27);
		c.getOperaciones().add("ListadoLibroIvaCompras_ObtenerListadoLibroIva");
		c.getOperaciones().add("ListadoLibroIvaComprasEnlaceExcel_ObtenerListadoLibroIva");
		c.getOperaciones().add("ListadoLibroIvaComprasDeProveedor_ObtenerListadoLibroIva");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(28);
		c.getOperaciones().add("ListadorArchivoAcreedores_ObtenerListadoAcreedores");
		c.getOperaciones().add("ListadorArchivoClientes_ObtenerListadoClientes");
		c.getOperaciones().add("ListadorArchivoClientesMonotributistas_ObtenerListadoClientes");
		c.getOperaciones().add("ListadorArchivoProveedores_ObtenerListadoProveedores");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(29);
		c.getOperaciones().add("ListadorCuentaCorrienteBolsas_ObtenerListadoCuentaCorrienteBolsas");
		c.getOperaciones().add("ListadorCuentasAcreedores_ObtenerListadoCuentaAcreedores");
		c.getOperaciones().add("ListadorCuentasAcreedoresSalidaExcel_ObtenerListadoCuentaAcreedores");
		c.getOperaciones().add("ListadorCuentasCorrientes_ObtenerListadoCuentaCorrientes");
		c.getOperaciones().add("ListadorCuentasCorrientesEnGestionJudicial_ObtenerListadoCuentaCorrientesEnGestionJudicial");
		c.getOperaciones().add("ListadorCuentasProveedores_ObtenerListadoCuentaProveedores");
		c.getOperaciones().add("ListadorCuentasVendedores_ObtenerListadoCuentaVendedores");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(30);
		c.getOperaciones().add("ListadorDeudasParaVendedor_ObtenerListadoDeudas");
		c.getOperaciones().add("ListadorDeudasParaVendedorSalidaExcel_ObtenerListadoDeudas");
		c.getOperaciones().add("ListadorDeudasUnCliente_ObtenerListadoDeudas");
		c.getOperaciones().add("ListadorDeudas_ObtenerListadoDeudas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(31);
		c.getOperaciones().add("ListadorDeudasChequesRechazados_ObtenerListadoDeudasChequesRechazados");
		c.getOperaciones().add("ListadorDeudasChequesRechazadosSalidaExcel_ObtenerListadoDeudasChequesRechazados");
		c.getOperaciones().add("ListadorDeudasChequesRechazadosCartaConvalidando_ObtenerListadoDeudasChequesRechazadosCartaReclamo");
		c.getOperaciones().add("ListadorDeudasChequesRechazadosCartaReclamo_ObtenerListadoDeudasChequesRechazadosCartaReclamo");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(32);
		c.getOperaciones().add("ListadorEstadististicas_ObtenerListadoEstadisticas");
		c.getOperaciones().add("ListadorEstadisticasSegunCondicionIva_ObtenerListadoEstadisticas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(33);
		c.getOperaciones().add("ListadorLibroIva_ObtenerListadoLibroIva");
		c.getOperaciones().add("ListadorLibroIvaEntreFechas_ObtenerListadoLibroIva");
		c.getOperaciones().add("ListadorLibroIvaSalidaExcel_ObtenerListadoLibroIva");
		c.getOperaciones().add("ListadorLibroIvaSalidaExcelVariosPeriodos_ObtenerListadoLibroIva");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(34);
		c.getOperaciones().add("ListadoVeintePrimerosDeudoresAcreedoresProveedores_ObtenerListadoDeudores");
		c.getOperaciones().add("ListadoVeintePrimerosDeudoresAcreedoresProveedoresSalidaExcel_ObtenerListadoDeudores");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(36);
		c.getOperaciones().add("NotaDeCreditoSinRemitoConPedidos_RealizarNotaCredito");
		c.getOperaciones().add("NotasDebitoChequesRechazados_RealizarNotaDebito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(37);
		c.getOperaciones().add("PedidosPendientesPorArticuloCliente_ObtenerListadoPedidosPendientes");
		c.getOperaciones().add("PedidosPendientesPorZonaSalidaExcel_ObtenerPedidosPendientes");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(38);
		c.getOperaciones().add("ArmadoSicorePercepcionesIngresosBrutos_ArmarSicorePercepcionesIngresosBrutos");
		c.getOperaciones().add("ArmadoSicoreRetencionesIngresosBrutos_ArmarSicoreRetenciones");
		c.getOperaciones().add("ArmadoSicoreRetenciones_ArmarSicoreReteneciones");
		c.getOperaciones().add("AcopleSicoreDesdeLibroOrdenesPago_AcoplarASicore");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(39);
		c.getOperaciones().add("VentasPorZona_ObtenerListadoVentasPorZona");
		c.getOperaciones().add("VentasPorZonaSubproductoMesSalidaExcel_ObtenerListadoVentasPorZonaSubproductosMesSalidaExcel");
		c.getOperaciones().add("VentasPorZonaSubproductoMesSalidaExcelDetalle_ObtenerListadoVentasPorZonaSubproductosMesSalidaExcelDetalle");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(40);
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(41);
		c.getOperaciones().add("AnulacionEntregaMercaderiaSinFacturaConPedido_AnularMercaderia");
		c.getOperaciones().add("AnulacionFacturasMercaderiaNoEntregada_AnularFactura");
		c.getOperaciones().add("AnulacionRecibos_AnularRecibo");
		c.getOperaciones().add("AnulacionRemitosMercaderiaEntregada_AnularRemito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(42);
		c.getOperaciones().add("CobranzaPorZonaMes_ObtenerListadoCobranzasPorZona");
		c.getOperaciones().add("CobranzaClientesPorZona_ObtenerListadoCobranzasPorZona");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(43);
		c.getOperaciones().add("FacturacionSinPedidos_FacturarPedido");
		c.getOperaciones().add("FacturacionSinPedidosConceptosVariosExportacion_FacturarPedido");
		c.getOperaciones().add("FacturacionSinPedidosMercaderiaAEntregar_FacturarPedido");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(44);
		c.getOperaciones().add("ImpresorPreciosPromedios_ObtenerListadoPreciosPromedios");
		c.getOperaciones().add("ImpresorPreciosPromediosTrigo_ObtenerListadoPreciosPromedios");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(49);
		c.getOperaciones().add("AbmConsultaArchivoTelefono_ConsultaTelefono");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(53);
		c.getOperaciones().add("AbuInterdepositos_UtilizacionInterdeposito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(54);
		c.getOperaciones().add("AcreditacionComisiones_AcreditarComision");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(56);
		c.getOperaciones().add("AnalisisSituacionZonasDeVenta_AnalizarSituacionZonasDeVenta");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(57);
		c.getOperaciones().add("ArmadoArchivosComunicacionCartaPorteRecibidas_ArmarArchivosComunicacion");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(58);
		c.getOperaciones().add("ArmadoCitiCompras_ArmarCitiCompras");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(59);
		c.getOperaciones().add("ArmaRegistroRetenciones_ArmarRegistroRetenciones");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(63);
		c.getOperaciones().add("BalanceCuentasCorrientesGestionJudicial_ObtenerBalanceCuentasCorrientesGestionJudicial");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(64);
		c.getOperaciones().add("BalanceDeudasCuentasCorrientes_ObtenerBalanceDeudasCuentasCorrientes");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(65);
		c.getOperaciones().add("BalanceEntreCuentasCorrientesYArrastreSaldos_ObtenerBalanceEntreCuentasCorrientesYArrastreSaldo");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(66);
		c.getOperaciones().add("BusquedaMovimientosRepetidosMercaderiaAEntregar_ObtenerListadoMovimientosRepetidosMercaderiaAEntregar");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(68);
		c.getOperaciones().add("ChequesAFechaPorZonaMes_GenerarListadoCheques");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(69);
		c.getOperaciones().add("ComplementoAlEmisorRecibos_ComplementarRecibos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(70);
		c.getOperaciones().add("ConsultaListaMercaderiaAEntregar_ObtenerListadoMercaderiaAEntrengar");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(71);
		c.getOperaciones().add("ConversionPadronIngresosBrutos_ConvertirPadronIngresosBrutos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(72);
		c.getOperaciones().add("CreditosPorDevoluciones_RealizarCredito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(73);
		c.getOperaciones().add("CruceTotalesMovimientoMercaderiasSalidaExcel_CruzarTotalesMovimientos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(74);
		c.getOperaciones().add("CuentaBolsasPorPantalla_ContarBolsas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(75);
		c.getOperaciones().add("DepositoEntregaChequesEnCartera_RealizarDeposito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(76);
		c.getOperaciones().add("DescuentosConcedidosPorZonasMesSalidaExcel_ObtenerListadoDescuentos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(77);
		c.getOperaciones().add("DetalleRetencionesLibroOrdenesPago_ObtenerDetalleRetencionesOrdenesPago");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(78);
		c.getOperaciones().add("DeudasPorPantalla_ObtenerListadoDeudas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(79);
		c.getOperaciones().add("DeudoresQueExcedenTope_ObtenerListadoDeudores");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(80);
		c.getOperaciones().add("DevolucionPedidosConRemito_DevolverPedido");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(81);
		c.getOperaciones().add("DuplicadoOrdenesPagoYComprobanteRetenciones_ObtenerListadoDuplicadoOrdenesPago");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(82);
		c.getOperaciones().add("EmisionCartasPorte_EmitirCartaPorte");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(83);
		c.getOperaciones().add("EmisionConFacturaDeCredito_EmitirConFacturaDeCredito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(84);
		c.getOperaciones().add("EmisionManualCreditosCobranza_EmitirCreditosCobranza");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(85);
		c.getOperaciones().add("EmisionOrdenesPagoYComprobantesRetenciones_EmitirOrdenPagoYComprobanteRetencion");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(86);
		c.getOperaciones().add("EndosoChequesEnCartera_EndosarCheque");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(87);
		c.getOperaciones().add("FacturacionManualFletes_FacturarFlete");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(88);
		c.getOperaciones().add("FacturacionMercaderiaYaEntregada_FacturarPedido");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(89);
		c.getOperaciones().add("GeneraArchivoDgiMoliendaTerceros_GenerarArchivoDgi");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(90);
		c.getOperaciones().add("ImpresionCarteraInterdepositos_ImprimirCarteraInterdepositos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(91);
		c.getOperaciones().add("ImpresionCuentasOtrosDeudores_ObtenerListadoCuentasOtroDeudores");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(92);
		c.getOperaciones().add("ImpresionFacturaCredito_ObtenerListadoFacturaCredito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(93);
		c.getOperaciones().add("ImpresionLibroBancos_ObtenerListadoLibroBancos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(94);
		c.getOperaciones().add("ImpresionLibroCartasPorteEmitidas_ObtenerListadoLibroCartasPorteEmitidas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(95);
		c.getOperaciones().add("ImpresionLibroOrdenesPago_ObtenerListadoLibroOrdenesPago");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(96);
		c.getOperaciones().add("ImpresionTotalesMovimientosStockMensual_ObtenerListadoTotalesMovimientosStockMensual");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(97);
		c.getOperaciones().add("ImpresorCarteraDocumentosACobrar_ObtenerListadoCarteraDocumentosACobrar");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(98);
		c.getOperaciones().add("IngresosAjustesStock_AjustarStock");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(99);
		c.getOperaciones().add("LibroComprasImputacionAPedidoPorPantalla_ObtenerListadoLibroComprasPorImputacion");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(100);
		c.getOperaciones().add("LiquidacionComisionVendedores_LiquidarComisionVendedores");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(102);
		c.getOperaciones().add("ListaDeudasND30_ObtenerListadoDeudas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(104);
		c.getOperaciones().add("ListadoComisionesPorVendedorMesSalidaExcel_ObtenerListadoComisionesPorVendedorMesSalidaExcel");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(105);
		c.getOperaciones().add("ListadoHarinaVendida_ObtenerListadoHarinaVendida");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(106);
		c.getOperaciones().add("ListadoHistoriaCobranzas_ObtenerListadoHistoriaCobranzas");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(107);
		c.getOperaciones().add("ListadorMovimientosCuentasAcreedoresPorVencimiento_ObtenerListadoMovimientos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(108);
		c.getOperaciones().add("ListadorNotasDebitoCreditoCerealSalidaExcel_ObtenerListadoNotasDebitoCredito");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(109);
		c.getOperaciones().add("ListadorNuevoLibroIvaDescuentosSinRecibos_ObtenerListadoNuevoLibroIva");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(110);
		c.getOperaciones().add("ListadorNuevoLibroRecibos_ObtenerListadoRecibos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(111);
		c.getOperaciones().add("ListadorPercepcionesLibroIva_ObtenerListadoPercepcionesLibroIva");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(112);
		c.getOperaciones().add("ListadoTotalesCobranzaMensual_ObtenerListadoTotalesCObranzaMensual");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(113);
		c.getOperaciones().add("ListadoTotalesLibroIvaCompras_ObtenerListadoTotalesLibroIva");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(114);
		c.getOperaciones().add("ListaHischeq_ObtenerListadoHischeq");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(115);
		c.getOperaciones().add("ListaKardex_ObtenerListaKardex");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(116);
		c.getOperaciones().add("ListaMayorSalidaExcel_ObtenerListadoMayor");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(117);
		c.getOperaciones().add("ListaSaldosPedidosSalidaExcel_ObtenerListadoSaldosPedidos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(118);
		c.getOperaciones().add("ListaSituacionTrigoUnaFechaSalidaExcel_ObtenerListadoSituacionTrigo");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(121);
		c.getOperaciones().add("MovimientoCliente_ObtenerListadoMovimientosCliente");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(122);
		c.getOperaciones().add("PagadoCtaCtePorAcreedorYFecha_ObtenerListadoPagado");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(123);
		c.getOperaciones().add("PreLiquidacionOrdenesPago_LiquidarOrdenPago");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(124);
		c.getOperaciones().add("TalonariosEntregadosSalidaExcel_ObtenerListadoTalonariosEntregados");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(125);
		c.getOperaciones().add("TransferenciasDentroDeudasClientes_TransferirImporte");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(126);
		c.getOperaciones().add("UnidadesEntregadasPorZona_ObtenerListadoUnidadEntregadasPorZona");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(127);
		c.getOperaciones().add("VerificacionEstadoArchivoFacturacion_VerificarEstadoArchivoFacturacion");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(128);
		c.getOperaciones().add("VerificaCuitProveedoresAcreedoresClientes_VerificarCuit");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(129);
		c.getOperaciones().add("VerificadorPadronIngresosBrutos_VerificarPadronIngresosBrutos");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);
		
		System.out.println("");
		System.out.println("Cantidad de Operaciones Imeroni: " + cantidadOp);
		System.out.println("");
		System.out.println("---------------------------------------------------------------------------");
		
		casosManuales.add(element);*/
		//-----------------------------------------------------------------------------------------
		
		cantidadOp = 0;
		c = new Clase();
		element = new RefactorizacionManual();
		element.setNombre("FernandezEmanuel");
		c.setClase(0);
		c.getOperaciones().add("AbmArchivoAcreedores_AltaAcreedor");
		c.getOperaciones().add("AbmArchivoClientes_AltaCliente");
		c.getOperaciones().add("AbmArchivoCreditosRecibosInterrumpidos_AltaCreditoReciboInterrumpido");
		c.getOperaciones().add("AbmArchivoProveedores_AltaProveedor");
		c.getOperaciones().add("AbmArchivoRecibos_AltaRecibo");
		c.getOperaciones().add("AbmArchivoVendedores_AltaVendedor");
		c.getOperaciones().add("AbmArticulos_AltaArticulo");
		c.getOperaciones().add("AbmClientesGestionJudicial_AltaCliente");
		c.getOperaciones().add("AbmComisiones_AltaComision");
		c.getOperaciones().add("AbmComprasSinInventario_AltaCompraSinInventario");
		c.getOperaciones().add("AbmCondiciones_AltaCondicion");
		c.getOperaciones().add("AbmConsultaArchivoTelefono_AltaTelefono");
		c.getOperaciones().add("AbmFletes_AltaFlete");
		c.getOperaciones().add("AbmMensajesClientes_AltaMensaje");
		c.getOperaciones().add("AbmOtrosDeudores_AltaOtroDeudor");
		c.getOperaciones().add("AbmPedidos_AltaPedidos");
		c.getOperaciones().add("AbuInterdepositos_AltaInterdeposito");
		c.getOperaciones().add("AltasYBajasDevolucionBolsas_AltaDevolucionBolsa");
		c.getOperaciones().add("AltasYBajasRecibosProvisoriosAnulados_AltaReciboProvisorio");
		c.getOperaciones().add("AltasYBajasTalonariosRecibosProvisoriosEnviados_AltaTalonario");
		c.getOperaciones().add("CajaIngresosYEgresos_AltaCaja");
		cantidadOp += c.getOperaciones().size();
		element.getClases().add(c);; //21 faltan
		
		c = new Clase();
		c.setClase(1);
		c.getOperaciones().add("AbmArchivoAcreedores_ModificacionAcreedor");
		c.getOperaciones().add("AbmArchivoClientes_ModificacionCliente");
		c.getOperaciones().add("AbmArchivoCreditosRecibosInterrumpidos_ModificacionCreditoReciboInterrumpido");
		c.getOperaciones().add("AbmArchivoProveedores_ModificacionProveedor");
		c.getOperaciones().add("AbmArchivoRecibos_ModificacionRecibo");
		c.getOperaciones().add("AbmArchivoVendedores_ModificacionVendedor");
		c.getOperaciones().add("AbmArticulos_ModificacionArticulo");
		c.getOperaciones().add("AbmClientesGestionJudicial_ModificacionCliente");
		c.getOperaciones().add("AbmCondiciones_ModificacionCondicion");
		c.getOperaciones().add("AbmConsultaArchivoTelefono_ModificacionTelefono");
		c.getOperaciones().add("AbmFletes_ModificacionFlete");
		c.getOperaciones().add("AbmMensajesClientes_ModificacionMensaje");
		c.getOperaciones().add("AbmOtrosDeudores_ModificacionOtroDeudor");
		c.getOperaciones().add("AbmPedidos_ModificacionPedidos");
		c.getOperaciones().add("ModificacionesArrastreCaja_ModificarArrastreCaja");
		c.getOperaciones().add("ModificacionesComisiones_ModificarComision");
		c.getOperaciones().add("CajaIngresosYEgresos_ModificacionCaja");
		cantidadOp += c.getOperaciones().size(); //17 faltan
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(2);
		c.getOperaciones().add("AbmArchivoProveedores_BajaProveedor");
		c.getOperaciones().add("AbmArchivoAcreedores_BajaAcreedor");
		c.getOperaciones().add("AbmArchivoVendedores_BajaVendedor");
		c.getOperaciones().add("AbmArchivoClientes_BajaCliente");
		c.getOperaciones().add("AbmArchivoCreditosRecibosInterrumpidos_BajaCreditoReciboInterrumpido");
		c.getOperaciones().add("AbmArchivoRecibos_BajaRecibo");
		c.getOperaciones().add("AbmArticulos_BajaArticulo");
		c.getOperaciones().add("AbmClientesGestionJudicial_BajaCliente");
		c.getOperaciones().add("AbmComprasSinInventario_BajaCompraSinInventario");
		c.getOperaciones().add("AbmCondiciones_BajaCondicion");
		c.getOperaciones().add("AbmConsultaArchivoTelefono_BajaTelefono");
		c.getOperaciones().add("AbmFletes_BajaFlete");
		c.getOperaciones().add("AbmMensajesClientes_BajaMensaje");
		c.getOperaciones().add("AbmOtrosDeudores_BajaOtroDeudor");
		c.getOperaciones().add("AbmPedidos_BajaPedidos");
		c.getOperaciones().add("AbuInterdepositos_BajaInterdeposito");
		c.getOperaciones().add("AltasYBajasDevolucionBolsas_BajaDevolucionBolsa");
		c.getOperaciones().add("AltasYBajasRecibosProvisoriosAnulados_BajaReciboProvisorio");
		c.getOperaciones().add("AltasYBajasTalonariosRecibosProvisoriosEnviados_BajaTalonario");
		c.getOperaciones().add("BajaChequesEndosadosNoRechazados_DarBajaCheque");
		c.getOperaciones().add("BajaIngresosYAjustesStock_BajaIngreso");
		c.getOperaciones().add("BajaLibrosOrdenesPago_BajaOrdenPago");
		c.getOperaciones().add("CajaIngresosYEgresos_BajaCaja");
		cantidadOp += c.getOperaciones().size(); //23 faltan
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(3);
		c.getOperaciones().add("ListadoCajaOrdenIngresosYEgresos_ObtenerListadoIngresosEgresos");
		c.getOperaciones().add("ListadoCajaOrdenIngresosEgresos_ObtenerListadoIngresosEgresos");
		cantidadOp += c.getOperaciones().size(); //
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(4);
		c.getOperaciones().add("ListaContabilizaBorraCaja_ObtenerListadoContabilizaBorraCaja");
		c.getOperaciones().add("ListadoCajaOrdenMayor_ObtenerListadoCajaOrdenMayor");
		cantidadOp += c.getOperaciones().size(); //
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(5);
		c.getOperaciones().add("MercaderiaAEntregarPorZona_ObtenerListadoMercaderiaAEntregar");
		c.getOperaciones().add("MercaderiaAEntregarPorZonaSalidaExcel_ObtenerListadoMercaderiaAEntregar");
		cantidadOp += c.getOperaciones().size(); //
		element.getClases().add(c);
		
		c = new Clase();
		c.setClase(6);
		
		cantidadOp += c.getOperaciones().size(); //
		element.getClases().add(c);
		
		System.out.println("");
		System.out.println("Cantidad de Operaciones FernandezEmanuel: " + cantidadOp);
		System.out.println("");
		System.out.println("---------------------------------------------------------------------------");
		
		casosManuales.add(element);
		//------------------------------------------------------------------------------------------
	}
}
