using System.Collections.Generic;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

public class Client
{
    public int codigo { get; set; }
    public int identificacion { get; set; }
    public string nombre { get; set; }
    public int canal { get; set; }

    public Client(int codigo, int identificacion, string nombre, int canal)
    {
        this.codigo = codigo;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.canal = canal;
    }
}