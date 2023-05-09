package petstore.dataFactory;

import petstore.pojo.CadastroPojo;

public class CadastroDataFactory {

    static CadastroPojo pedido = new CadastroPojo();

    public static CadastroPojo setBody(){
        pedido.setId(1);
        pedido.setPetId(1);
        pedido.setQuantity(1);
        pedido.setShipDate("2023-05-08T21:45");
        pedido.setStatus("placed");
        pedido.setComplete(true);
        return pedido;
    }
}
