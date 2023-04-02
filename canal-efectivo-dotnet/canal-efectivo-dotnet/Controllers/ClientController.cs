using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System.Collections.Generic;
using Newtonsoft.Json.Linq;

namespace canal_efectivo_dotnet.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class ClientController : ControllerBase
    {
        private static List<dynamic> json_clients = new List<dynamic>();
        
        static ClientController()
        {
            var clients = new List<Client>
            {
                new Client(200, 200, "cli net", 2),
                new Client(202, 202, "clic dotnet", 2)
            };
            foreach (var client in clients)
            {
                json_clients.Add(client);
            }
        }
       
        [HttpGet]
        public IActionResult ReturnClients()
        {
            return Ok(json_clients);
        }
        
        [HttpGet("{codigo}")]
        public IActionResult ReturnClient(int codigo)
        {
            var cliente = json_clients.Find(c => c.codigo == codigo);
            if (cliente == null)
            {
                return NotFound();
            }
            return Ok(cliente);
        }
        
        [HttpPost]
        public IActionResult AddClient([FromBody] Client client)
        {
            if (Request.ContentType == "application/json")
            {
                json_clients.Add(client);
                return Ok("OK");
            }
            else
            {
                return BadRequest("No valido");
            }
        }
    }
}