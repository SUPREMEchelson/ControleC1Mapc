package serviceprovider.api;

public enum BasicServiceTypeNames implements ServiceTypeName {
    WEB_SERVER {
        @Override
        public String getName() {
            return "web_server";
        }
    },
    APP_SERVER {
        @Override
        public String getName() {
            return "app_server";

        }
    },
    STORAGE_SERVER {
        @Override
        public String getName() {
            return "storage_server";
        }
    },
    LOGGING {
        @Override
        public String getName() {
            return "logging";
        }
    },

    MONITORING {
        @Override
        public String getName() {
            return "monitoring";
        }
    }
}
