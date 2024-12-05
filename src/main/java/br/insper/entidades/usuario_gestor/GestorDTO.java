package br.insper.entidades.usuario_gestor;


record CadastraGestorDTO
        (String nome, String senha, String email){

}

record RetornarGestorDTO
        (String id, String nome, String senha, String email){
}
