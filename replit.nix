{ pkgs }: {
    deps = [
      pkgs.vim
        pkgs.graalvm11-ce
        pkgs.maven
        pkgs.replitPackages.jdt-language-server
        pkgs.replitPackages.java-debug
    ];
}
