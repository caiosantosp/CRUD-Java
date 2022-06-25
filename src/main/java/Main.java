import br.com.contact.dao.ContactDAO;

public class Main {
    public static void main(String[] args) throws Exception {

        /** Pega a data de hoje **/
        // Date data = new Date();

        /** Cria um novo contato **/
        // Contact contato = new Contact("Pedro",23,"pedro,silva@gmail.com",data);

        /**
         * alterarAlgumContato()
        * Altera o contato desejado:
        * Passar valores em ordem: novoNome, novaIdade, novoEmail, novaDataDeCadastro,idDoContatoQueDesejaAlterar
        * Exemplo:
        **/
        // ContactDAO.alterarAlgumContato("Abelardo",56,"thebest@gmail.com",20220623,6584);

        /**
         * salvarContato()
         * Cria um novo contato:
         * Somente informar um contato já criado
         * Exemplo:
         **/
        // ContactDAO.salvarContato(contato);

        /**
         * deletarContato()
         * Deleta um contato existente:
         * Somente informar o id do contato que deseja deletar
         * Exemplo:
         **/
        // ContactDAO.deletarContato(12);

        /**
         * mostrarTodosContatos()
         * Mostra todos os contatos existentes:
         * Exemplo:
         **/
        // ContactDAO.mostrarTodosContatos();

        /**
         * mostrarAlgumContato()
         * Mostra algum contato buscando pelo ID:
         * Somente informar o id do contato que deseja buscar
         * Exemplo:
         **/
        // ContactDAO.mostrarAlgumContato(12);

        ContactDAO.buscarContatoPorNome("brabo");
    }
}
