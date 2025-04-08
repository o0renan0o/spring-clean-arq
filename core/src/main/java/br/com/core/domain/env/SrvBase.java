package br.com.core.domain.env;

public class SrvBase {
    private String url;
    private Endpoints endpoints;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Endpoints getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(Endpoints endpoints) {
        this.endpoints = endpoints;
    }

    public static class Endpoints {

        private String alteraApelido;
        private String alteraChave;

        public String getAlteraApelido() {
            return alteraApelido;
        }

        public void setAlteraApelido(String alteraApelido) {
            this.alteraApelido = alteraApelido;
        }

        public String getAlteraChave() {
            return alteraChave;
        }

        public void setAlteraChave(String alteraChave) {
            this.alteraChave = alteraChave;
        }
    }
}
