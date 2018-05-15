package org.clusterer.app;
import java.util.ArrayList;
import java.util.List;

public class CasoManualPreFijosEsteberena {

		private List<RefactorizacionManual> casosManuales = new ArrayList<RefactorizacionManual>();
		public List<RefactorizacionManual> getCasosManuales() {
			return casosManuales;
		}

		public void setCasosManuales(List<RefactorizacionManual> casosManuales) {
			this.casosManuales = casosManuales;
		}

		private int cantidadOp=0;
		
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

			element.setNombre("Esteberena");
						
			c.setClase(0);
			c.getOperaciones().add("AbmArchivoProveedores_AltaProveedor");
			c.getOperaciones().add("AbmArchivoAcreedores_AltaAcreedor");
			c.getOperaciones().add("AbmArchivoProveedores_BajaProveedor");
			c.getOperaciones().add("AbmArchivoAcreedores_BajaAcreedor");
			c.getOperaciones().add("AbmArchivoProveedores_ModificacionProveedor");
			c.getOperaciones().add("AbmArchivoAcreedores_ModificacionAcreedor");
			c.getOperaciones().add("AbmArchivoVendedores_AltaVendedor");
			c.getOperaciones().add("AbmArchivoClientes_AltaCliente");
			c.getOperaciones().add("AbmArchivoVendedores_BajaVendedor");
			c.getOperaciones().add("AbmArchivoClientes_BajaCliente");
			c.getOperaciones().add("AbmArchivoVendedores_ModificacionVendedor");
			c.getOperaciones().add("AbmArchivoClientes_ModificacionCliente");
			c.getOperaciones().add("AbmClientesGestionJudicial_AltaCliente");
			c.getOperaciones().add("AbmOtrosDeudores_AltaOtroDeudor");
			c.getOperaciones().add("AbmClientesGestionJudicial_BajaCliente");
			c.getOperaciones().add("AbmOtrosDeudores_BajaOtroDeudor");
			c.getOperaciones().add("AbmClientesGestionJudicial_ModificacionCliente");
			c.getOperaciones().add("AbmOtrosDeudores_ModificacionOtroDeudor");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);		
			
			c = new Clase();
			c.setClase(1);
			c.getOperaciones().add("AbmChequesRechazados_AltaCheque");
			c.getOperaciones().add("AbmChequesEnCartera_AltaCheque");
			c.getOperaciones().add("AbmChequesRechazados_BajaCheque");
			c.getOperaciones().add("AbmChequesEnCartera_BajaCheque");
			c.getOperaciones().add("AbmChequesRechazados_ModificacionCheque");
			c.getOperaciones().add("AbmChequesEnCartera_ModificacionCheque");
			c.getOperaciones().add("BajaChequesEndosadosNoRechazados_DarBajaCheque");
			c.getOperaciones().add("DepositoEntregaChequesEnCartera_RealizarDeposito");
			c.getOperaciones().add("EndosoChequesEnCartera_EndosarCheque");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(2);
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
			c.setClase(3);
			c.getOperaciones().add("AnulacionEntregaMercaderiaSinFacturaConPedido_AnularMercaderia");
			c.getOperaciones().add("AnulacionRemitosMercaderiaEntregada_AnularRemito");
			c.getOperaciones().add("DevolucionPedidosConRemito_DevolverPedido");
			c.getOperaciones().add("EntregaMercaderiaSinFacturaConPedido_EntregarMercaderia");
			c.getOperaciones().add("EntregaMercaderiaSinFacturaConPedidoParaExportacion_EntregarMercaderia");
			c.getOperaciones().add("EntregaMercaderiaSinFacturaNiPedido_EntregarMercaderia");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(4);
			c.getOperaciones().add("CuentaBolsasPorPantalla_ContarBolsas");
			c.getOperaciones().add("CuentasCorrientesAcreedoresPorPantalla_ObtenerListadoCuentasCorrientesAcreedores");
			c.getOperaciones().add("CuentasCorrientesProveedoresPorPantalla_ObtenerListadoCuentasCorrientesProveedores");
			c.getOperaciones().add("CuentasCorrientesVendedoresPorPantalla_ObtenerListadoCuentasCorrientesVendedores");
			c.getOperaciones().add("CuentasEnGestionJudicialPorPantalla_ObtenerListadoCuentasEnGestionJudicial");
			c.getOperaciones().add("CuentasOtrosDeudoresPorPantalla_ObtenerListadoCuentasOtrosDeudores");
			c.getOperaciones().add("CuentasCorrientesPorPantalla_ObtenerListadoCuentasCorrientes");
			c.getOperaciones().add("ImpresionCuentasOtrosDeudores_ObtenerListadoCuentasOtroDeudores");
			c.getOperaciones().add("ListadorCuentaCorrienteBolsas_ObtenerListadoCuentaCorrienteBolsas");
			c.getOperaciones().add("ListadorCuentasAcreedores_ObtenerListadoCuentaAcreedores");
			c.getOperaciones().add("ListadorCuentasAcreedoresSalidaExcel_ObtenerListadoCuentaAcreedores");
			c.getOperaciones().add("ListadorCuentasCorrientes_ObtenerListadoCuentaCorrientes");
			c.getOperaciones().add("ListadorCuentasCorrientesEnGestionJudicial_ObtenerListadoCuentaCorrientesEnGestionJudicial");
			c.getOperaciones().add("ListadorCuentasProveedores_ObtenerListadoCuentaProveedores");
			c.getOperaciones().add("ListadorCuentasVendedores_ObtenerListadoCuentaVendedores");
			c.getOperaciones().add("ListadorMovimientosCuentasAcreedoresPorVencimiento_ObtenerListadoMovimientos");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(5);
			c.getOperaciones().add("CreditosPorDevoluciones_RealizarCredito");
			c.getOperaciones().add("DebitosCreditosCompraCereal_RealizarCredito");
			c.getOperaciones().add("DebitosCreditosVarios_RealizarCredito");
			c.getOperaciones().add("EmisionManualCreditosCobranza_EmitirCreditosCobranza");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(6);
			c.getOperaciones().add("BalanceMayorProveedoresPorCodigoProveedor_ObtenerBalanceMayorProveedoresPorCodigoProveedor");
			c.getOperaciones().add("BalanceArchivosDiarios_ObtenerBalanceArchivosDiarios");
			c.getOperaciones().add("BalanceLibroIva_ObtenerBalanceLibroIva");
			c.getOperaciones().add("BalanceCuentaDeudasYCuentaCorriente_ObtenerBalanceCuentaDeudasYCuentaCorriente");
			c.getOperaciones().add("BalanceCuentaDeudasYCuentaCorrienteSalidaExcel_ObtenerBalanceCuentaDeudasYCuentaCorrienteSalidaExcel");
			c.getOperaciones().add("BalanceCuentaDeudasYCuentaCorrienteSalidaAExcel_ObtenerBalanceCuentaDeudasYCuentaCorrienteSalidaAExcel");
			c.getOperaciones().add("BalanceCuentasCorrientesGestionJudicial_ObtenerBalanceCuentasCorrientesGestionJudicial");
			c.getOperaciones().add("BalanceDeudasCuentasCorrientes_ObtenerBalanceDeudasCuentasCorrientes");
			c.getOperaciones().add("BalanceEntreCuentasCorrientesYArrastreSaldos_ObtenerBalanceEntreCuentasCorrientesYArrastreSaldo");
			c.getOperaciones().add("BalanceMovimientosCuentasCorrientes_ObtenerBalanceMovimientosCuentasCorrientes");
			c.getOperaciones().add("BalanceMovimientosCuentasProveedoresAcreedores_ObtenerBalanceMovimientosCuentasProveedoresAcreedores");
			c.getOperaciones().add("BalanceMovimientosCuentasProveedoresAcreedoresSalidaExcel_ObtenerBalanceMovimientosCuentasProveedoresAcreedoresSalidaExcel");
			c.getOperaciones().add("BalanceSaldosAcreedoresProveedores_ObtenerBalanceSaldosAcreedoresProveedores");
			c.getOperaciones().add("BalanceSaldosClientes_ObtenerBalanceSaldosClientes");
			c.getOperaciones().add("BalanceSaldosClientesSalidaExcel_ObtenerBalanceSaldosClientesSalidaExcel");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(7);
			c.getOperaciones().add("ArmadoSicorePercepcionesIngresosBrutos_ArmarSicorePercepcionesIngresosBrutos");
			c.getOperaciones().add("ArmadoSicoreRetencionesIngresosBrutos_ArmarSicoreRetenciones");
			c.getOperaciones().add("ArmadoSicoreRetenciones_ArmarSicoreReteneciones");
			c.getOperaciones().add("AcopleSicoreDesdeLibroOrdenesPago_AcoplarASicore");
			c.getOperaciones().add("ArmaRegistroRetenciones_ArmarRegistroRetenciones");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(8);
			c.getOperaciones().add("ChequesAFechaPorZonaMes_GenerarListadoCheques");
			c.getOperaciones().add("ListadoChequesRechazados_ObtenerListadoChequesRechazados");
			c.getOperaciones().add("ListadoChequesRecibidos_ObtenerListadoChequesRecibidos");
			c.getOperaciones().add("ListadoChequesRecibidosSalidaExcel_ObtenerListadoChequesRecibidosSalidaExcel");
			c.getOperaciones().add("ListaHischeq_ObtenerListadoHischeq");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(9);
			c.getOperaciones().add("ConsultaListaMercaderiaAEntregar_ObtenerListadoMercaderiaAEntrengar");
			c.getOperaciones().add("ListaSaldosPedidosSalidaExcel_ObtenerListadoSaldosPedidos");
			c.getOperaciones().add("MercaderiaAEntregarPorZona_ObtenerListadoMercaderiaAEntregar");
			c.getOperaciones().add("MercaderiaAEntregarPorZonaSalidaExcel_ObtenerListadoMercaderiaAEntregar");
			c.getOperaciones().add("PedidosPendientesPorArticuloCliente_ObtenerListadoPedidosPendientes");
			c.getOperaciones().add("PedidosPendientesPorZonaSalidaExcel_ObtenerPedidosPendientes");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(10);
			c.getOperaciones().add("BusquedaMovimientosRepetidosMercaderiaAEntregar_ObtenerListadoMovimientosRepetidosMercaderiaAEntregar");
			c.getOperaciones().add("CruceTotalesMovimientoMercaderiasSalidaExcel_CruzarTotalesMovimientos");
			c.getOperaciones().add("ImpresionTotalesMovimientosStockMensual_ObtenerListadoTotalesMovimientosStockMensual");
			c.getOperaciones().add("MovimientoCliente_ObtenerListadoMovimientosCliente");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(11);
			c.getOperaciones().add("AbmArticulos_AltaArticulo");
			c.getOperaciones().add("AbmArticulos_BajaArticulo");
			c.getOperaciones().add("AbmArticulos_ModificacionArticulo");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(12);
			c.getOperaciones().add("ListaContabilizaBorraCaja_ObtenerListadoContabilizaBorraCaja");
			c.getOperaciones().add("ListadoCajaOrdenIngresosYEgresos_ObtenerListadoIngresosEgresos");
			c.getOperaciones().add("ListadoCajaOrdenIngresosEgresos_ObtenerListadoIngresosEgresos");
			c.getOperaciones().add("ListadoCajaOrdenMayor_ObtenerListadoCajaOrdenMayor");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(13);
			c.getOperaciones().add("AnalisisSituacionZonasDeVenta_AnalizarSituacionZonasDeVenta");
			c.getOperaciones().add("CobranzaPorZonaMes_ObtenerListadoCobranzasPorZona");
			c.getOperaciones().add("CobranzaClientesPorZona_ObtenerListadoCobranzasPorZona");
			c.getOperaciones().add("DescuentosConcedidosPorZonasMesSalidaExcel_ObtenerListadoDescuentos");
			c.getOperaciones().add("ListadoComisionesPorVendedorMesSalidaExcel_ObtenerListadoComisionesPorVendedorMesSalidaExcel");
			c.getOperaciones().add("UnidadesEntregadasPorZona_ObtenerListadoUnidadEntregadasPorZona");
			c.getOperaciones().add("VentasPorZona_ObtenerListadoVentasPorZona");
			c.getOperaciones().add("VentasPorZonaSubproductoMesSalidaExcel_ObtenerListadoVentasPorZonaSubproductosMesSalidaExcel");
			c.getOperaciones().add("VentasPorZonaSubproductoMesSalidaExcelDetalle_ObtenerListadoVentasPorZonaSubproductosMesSalidaExcelDetalle");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(14);
			c.getOperaciones().add("LibroComprasImputacionAPedidoPorPantalla_ObtenerListadoLibroComprasPorImputacion");
			c.getOperaciones().add("LibroVentasPorImputacionAPedido_ObtenerListadoLibroVentasPorImputacion");
			c.getOperaciones().add("LibroVentasPorImputacionAPedidoSalidaExcel_ObtenerListadoLibroVentasPorImputacion");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(15);
			c.getOperaciones().add("ListadorArchivoAcreedores_ObtenerListadoAcreedores");
			c.getOperaciones().add("ListadorArchivoClientes_ObtenerListadoClientes");
			c.getOperaciones().add("ListadorArchivoClientesMonotributistas_ObtenerListadoClientes");
			c.getOperaciones().add("ListadorArchivoProveedores_ObtenerListadoProveedores");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(16);
			c.getOperaciones().add("ControlSecuenciaLibroIva_ControlarSecuenciaLibroIva");
			c.getOperaciones().add("ListadoLibroIvaCompras_ObtenerListadoLibroIva");
			c.getOperaciones().add("ListadoLibroIvaComprasEnlaceExcel_ObtenerListadoLibroIva");
			c.getOperaciones().add("ListadoLibroIvaComprasDeProveedor_ObtenerListadoLibroIva");
			c.getOperaciones().add("ListadorLibroIva_ObtenerListadoLibroIva");
			c.getOperaciones().add("ListadorLibroIvaEntreFechas_ObtenerListadoLibroIva");
			c.getOperaciones().add("ListadorLibroIvaSalidaExcel_ObtenerListadoLibroIva");
			c.getOperaciones().add("ListadorLibroIvaSalidaExcelVariosPeriodos_ObtenerListadoLibroIva");
			c.getOperaciones().add("ListadorNuevoLibroIvaDescuentosSinRecibos_ObtenerListadoNuevoLibroIva");
			c.getOperaciones().add("ListadorPercepcionesLibroIva_ObtenerListadoPercepcionesLibroIva");
			c.getOperaciones().add("ListadoTotalesLibroIvaCompras_ObtenerListadoTotalesLibroIva");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(17);
			c.getOperaciones().add("DeudasPorPantalla_ObtenerListadoDeudas");
			c.getOperaciones().add("DeudoresQueExcedenTope_ObtenerListadoDeudores");
			c.getOperaciones().add("ListaDeudasND30_ObtenerListadoDeudas");
			c.getOperaciones().add("ListadoDeudoresPorVentasZonaMesSalidaExcel_ObtenerListadoDeudoresPorVentasZonaMesSalidaExcel");
			c.getOperaciones().add("ListadoDeudoresGestionJudicialPorZonaMesSalidaExcel_ObtenerListadoDeudoresGestionJudicialPorZonaMesSalidaExcel");
			c.getOperaciones().add("ListadorDeudas_ObtenerListadoDeudas");
			c.getOperaciones().add("ListadorDeudasChequesRechazados_ObtenerListadoDeudasChequesRechazados");
			c.getOperaciones().add("ListadorDeudasChequesRechazadosSalidaExcel_ObtenerListadoDeudasChequesRechazados");
			c.getOperaciones().add("ListadorDeudasChequesRechazadosCartaConvalidando_ObtenerListadoDeudasChequesRechazadosCartaReclamo");
			c.getOperaciones().add("ListadorDeudasChequesRechazadosCartaReclamo_ObtenerListadoDeudasChequesRechazadosCartaReclamo");
			c.getOperaciones().add("ListadorDeudasParaVendedor_ObtenerListadoDeudas");
			c.getOperaciones().add("ListadorDeudasParaVendedorSalidaExcel_ObtenerListadoDeudas");
			c.getOperaciones().add("ListadorDeudasUnCliente_ObtenerListadoDeudas");
			c.getOperaciones().add("ListadoVeintePrimerosDeudoresAcreedoresProveedores_ObtenerListadoDeudores");
			c.getOperaciones().add("ListadoVeintePrimerosDeudoresAcreedoresProveedoresSalidaExcel_ObtenerListadoDeudores");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(18);
			c.getOperaciones().add("InformeClientesParaSecretariaComercio_ObtenerInformeClientes");
			c.getOperaciones().add("InformeClientesParaSecretariaComercioHarina000_ObtenerInformeClientes");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(19);
			c.getOperaciones().add("ImpresionFacturaCredito_ObtenerListadoFacturaCredito");
			c.getOperaciones().add("ListadoFacturadoClienteEntreFechasAPedido_ObtenerListadoFacturacion");
			c.getOperaciones().add("ListadoFacturadoClienteEntreFechasAPedidoSalidaExcel_ObtenerListadoFacturacion");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(20);
			c.getOperaciones().add("ArmadoListadoSubsidios_ArmarListadosSubsidios");
			c.getOperaciones().add("ArmadoListadoSubsidiosSalidaExcel_ArmarListadosSubsidios");
			c.getOperaciones().add("ExcelParaSubsidios_ObtenerListadoSubsidios");
			c.getOperaciones().add("ExcelParaInformeOnca_ObtenerListadoOnca");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(21);
			c.getOperaciones().add("ListaKardex_ObtenerListaKardex");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(22);
			c.getOperaciones().add("ListaMayorSalidaExcel_ObtenerListadoMayor");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(23);
			c.getOperaciones().add("CajaIngresosYEgresos_AltaCaja");
			c.getOperaciones().add("CajaIngresosYEgresos_BajaCaja");
			c.getOperaciones().add("CajaIngresosYEgresos_ModificacionCaja");
			c.getOperaciones().add("ModificacionesArrastreCaja_ModificarArrastreCaja");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(24);
			c.getOperaciones().add("AbmArchivoRecibos_AltaRecibo");
			c.getOperaciones().add("AbmArchivoRecibos_BajaRecibo");
			c.getOperaciones().add("AbmArchivoRecibos_ModificacionRecibo");
			c.getOperaciones().add("AltasYBajasTalonariosRecibosProvisoriosEnviados_AltaTalonario");
			c.getOperaciones().add("AltasYBajasRecibosProvisoriosAnulados_AltaReciboProvisorio");
			c.getOperaciones().add("AltasYBajasTalonariosRecibosProvisoriosEnviados_BajaTalonario");
			c.getOperaciones().add("AltasYBajasRecibosProvisoriosAnulados_BajaReciboProvisorio");
			c.getOperaciones().add("AnulacionRecibos_AnularRecibo");
			c.getOperaciones().add("ComplementoAlEmisorRecibos_ComplementarRecibos");
			c.getOperaciones().add("EmisionRecibos_EmitirRecibos");
			c.getOperaciones().add("EmisionRecibosCobroDeudores_EmitirRecibos");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(25);
			c.getOperaciones().add("AbmFletes_AltaFlete");
			c.getOperaciones().add("AbmFletes_BajaFlete");
			c.getOperaciones().add("AbmFletes_ModificacionFlete");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(26);
			c.getOperaciones().add("AbmPedidos_AltaPedidos");
			c.getOperaciones().add("AbmPedidos_BajaPedidos");
			c.getOperaciones().add("AbmPedidos_ModificacionPedidos");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(27);
			c.getOperaciones().add("TransferenciasDentroDeudasClientes_TransferirImporte");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(28);
			c.getOperaciones().add("GeneraArchivoDgiMoliendaTerceros_GenerarArchivoDgi");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(29);
			c.getOperaciones().add("ControlNumeracionRecibos_ControlarNumeracionRecibos");
			c.getOperaciones().add("ControlRecibosProvisoriosEnviadosRecibidos_ControlarRecibosProvisorios");
			c.getOperaciones().add("ControlRecibosProvisoriosEnviadosRecibidosSalidaExcel_ControlarRecibosProvisorios");
			c.getOperaciones().add("ControlRecibosProvisoriosRecibidos_ControlarRecibosProvisorios");
			c.getOperaciones().add("ControlRecibosProvisoriosRecibidosSalidaExcel_ControlarRecibosProvisorios");
			c.getOperaciones().add("ListadorNuevoLibroRecibos_ObtenerListadoRecibos");
			c.getOperaciones().add("TalonariosEntregadosSalidaExcel_ObtenerListadoTalonariosEntregados");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(30);
			c.getOperaciones().add("AbmComisiones_AltaComision");
			c.getOperaciones().add("AcreditacionComisiones_AcreditarComision");
			c.getOperaciones().add("LiquidacionComisionVendedores_LiquidarComisionVendedores");
			c.getOperaciones().add("ModificacionesComisiones_ModificarComision");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(31);
			c.getOperaciones().add("AbmComprasSinInventario_AltaCompraSinInventario");
			c.getOperaciones().add("AbmComprasSinInventario_BajaCompraSinInventario");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(32);
			c.getOperaciones().add("EmisionCartasPorte_EmitirCartaPorte");
			c.getOperaciones().add("ImpresionLibroCartasPorteEmitidas_ObtenerListadoLibroCartasPorteEmitidas");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(33);
			c.getOperaciones().add("ImpresionLibroOrdenesPago_ObtenerListadoLibroOrdenesPago");
			c.getOperaciones().add("BajaLibrosOrdenesPago_BajaOrdenPago");
			c.getOperaciones().add("DetalleRetencionesLibroOrdenesPago_ObtenerDetalleRetencionesOrdenesPago");
			c.getOperaciones().add("DuplicadoOrdenesPagoYComprobanteRetenciones_ObtenerListadoDuplicadoOrdenesPago");
			c.getOperaciones().add("EmisionOrdenesPagoYComprobantesRetenciones_EmitirOrdenPagoYComprobanteRetencion");
			c.getOperaciones().add("PreLiquidacionOrdenesPago_LiquidarOrdenPago");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(34);
			c.getOperaciones().add("AbmMensajesClientes_AltaMensaje");
			c.getOperaciones().add("AbmMensajesClientes_BajaMensaje");
			c.getOperaciones().add("AbmMensajesClientes_ModificacionMensaje");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(35);
			c.getOperaciones().add("AbmCondiciones_AltaCondicion");
			c.getOperaciones().add("AbmCondiciones_BajaCondicion");
			c.getOperaciones().add("AbmCondiciones_ModificacionCondicion");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(36);
			c.getOperaciones().add("BajaIngresosYAjustesStock_BajaIngreso");
			c.getOperaciones().add("IngresosAjustesStock_AjustarStock");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(37);
			c.getOperaciones().add("ConversionPadronIngresosBrutos_ConvertirPadronIngresosBrutos");
			c.getOperaciones().add("VerificadorPadronIngresosBrutos_VerificarPadronIngresosBrutos");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(38);
			c.getOperaciones().add("AbuInterdepositos_AltaInterdeposito");
			c.getOperaciones().add("AbuInterdepositos_BajaInterdeposito");
			c.getOperaciones().add("AbuInterdepositos_UtilizacionInterdeposito");
			c.getOperaciones().add("ImpresionCarteraInterdepositos_ImprimirCarteraInterdepositos");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(39);
			c.getOperaciones().add("ArmadoCitiCompras_ArmarCitiCompras");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(40);
			c.getOperaciones().add("PagadoCtaCtePorAcreedorYFecha_ObtenerListadoPagado");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(41);
			c.getOperaciones().add("AltasYBajasDevolucionBolsas_AltaDevolucionBolsa");
			c.getOperaciones().add("AltasYBajasDevolucionBolsas_BajaDevolucionBolsa");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(42);
			c.getOperaciones().add("ImpresorCarteraDocumentosACobrar_ObtenerListadoCarteraDocumentosACobrar");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(43);
			c.getOperaciones().add("ListadorNotasDebitoCreditoCerealSalidaExcel_ObtenerListadoNotasDebitoCredito");
			c.getOperaciones().add("NotaDeCreditoSinRemitoConPedidos_RealizarNotaCredito");
			c.getOperaciones().add("NotasDebitoChequesRechazados_RealizarNotaDebito");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(44);
			c.getOperaciones().add("ImpresorPreciosPromedios_ObtenerListadoPreciosPromedios");
			c.getOperaciones().add("ImpresorPreciosPromediosTrigo_ObtenerListadoPreciosPromedios");
			c.getOperaciones().add("ListadoHarinaVendida_ObtenerListadoHarinaVendida");
			c.getOperaciones().add("ListadorEstadististicas_ObtenerListadoEstadisticas");
			c.getOperaciones().add("ListadorEstadisticasSegunCondicionIva_ObtenerListadoEstadisticas");
			c.getOperaciones().add("ListadoTotalesCobranzaMensual_ObtenerListadoTotalesCObranzaMensual");
			c.getOperaciones().add("ListaSituacionTrigoUnaFechaSalidaExcel_ObtenerListadoSituacionTrigo");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(45);
			c.getOperaciones().add("VerificaCuitProveedoresAcreedoresClientes_VerificarCuit");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(46);
			c.getOperaciones().add("AnulacionFacturasMercaderiaNoEntregada_AnularFactura");
			c.getOperaciones().add("EmisionConFacturaDeCredito_EmitirConFacturaDeCredito");
			c.getOperaciones().add("FacturacionManualFletes_FacturarFlete");
			c.getOperaciones().add("FacturacionMercaderiaYaEntregada_FacturarPedido");
			c.getOperaciones().add("FacturacionPedidosSinEntregaMercaderia_FacturarPedido");
			c.getOperaciones().add("FacturacionPedidosSinEntregaMercaderiaExportación_FacturarPedido");
			c.getOperaciones().add("FacturacionPedidos_FacturarPedido");
			c.getOperaciones().add("FacturacionSinPedidos_FacturarPedido");
			c.getOperaciones().add("FacturacionSinPedidosConceptosVariosExportacion_FacturarPedido");
			c.getOperaciones().add("FacturacionSinPedidosMercaderiaAEntregar_FacturarPedido");
			c.getOperaciones().add("VerificacionEstadoArchivoFacturacion_VerificarEstadoArchivoFacturacion");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(47);
			c.getOperaciones().add("AbmArchivoCreditosRecibosInterrumpidos_AltaCreditoReciboInterrumpido");
			c.getOperaciones().add("AbmArchivoCreditosRecibosInterrumpidos_BajaCreditoReciboInterrumpido");
			c.getOperaciones().add("AbmArchivoCreditosRecibosInterrumpidos_ModificacionCreditoReciboInterrumpido");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(48);
			c.getOperaciones().add("ArmadoArchivosComunicacionCartaPorteRecibidas_ArmarArchivosComunicacion");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(49);
			c.getOperaciones().add("ImpresionLibroBancos_ObtenerListadoLibroBancos");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(50);
			c.getOperaciones().add("ListadoHistoriaCobranzas_ObtenerListadoHistoriaCobranzas");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			c = new Clase();
			c.setClase(51);
			c.getOperaciones().add("AbmConsultaArchivoTelefono_AltaTelefono");
			c.getOperaciones().add("AbmConsultaArchivoTelefono_BajaTelefono");
			c.getOperaciones().add("AbmConsultaArchivoTelefono_ConsultaTelefono");
			c.getOperaciones().add("AbmConsultaArchivoTelefono_ModificacionTelefono");
			c.getOperaciones().add("ImpresionArchivoTelefono_ObtenerListadoTelefonos");
			c.getOperaciones().add("ImpresionArchivoTelefonoSalidaExcel_ObtenerListadoTelefonos");
			cantidadOp += c.getOperaciones().size();
			element.getClases().add(c);
			
			System.out.println("");
			System.out.println("Cantidad de Operaciones Esteberena: " + cantidadOp);
			System.out.println("");
			System.out.println("---------------------------------------------------------------------------");
			
			casosManuales.add(element);
		}	
}
