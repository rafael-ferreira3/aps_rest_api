package br.com.aps_rest_api.endpoint.pedido;

import br.com.aps_rest_api.service.pedido.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api("Api de Pedidos")
@CrossOrigin(origins = "*")
public class PedidoEndPoint {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/pedido")
    @ApiOperation("Cria o Pedido Baseado em um carrinho")
    public PedidoQuery gerarPedido(@RequestBody GerarPedidoParam gerarPedidoParam){
        return pedidoService.gerarPedido(gerarPedidoParam.getIdCliente());
    }

    @GetMapping("/pedidos/{idCliente}")
    @ApiOperation("Lista todos os pedidos do cliente")
    public List<PedidoQuery> buscaPedidosPorCliente(@PathVariable Long idCliente){
        return pedidoService.buscaPedidosPorCliente(idCliente);
    }

}
