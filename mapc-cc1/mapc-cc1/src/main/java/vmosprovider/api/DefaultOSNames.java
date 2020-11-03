package vmosprovider.api;

public enum DefaultOSNames implements VmOSName {
    CENTOS_8_1 {
        @Override
        public String getName(){
            return "centos-8.1";
        }
    },
    DEBIAN_10_6 {
        @Override
        public String getName(){
            return "debian-10.6";
        }
    },
    FEDORA_31 {
        @Override
        public String getName(){
            return "fedora-31";
        }
    },
    UBUNTU_18_10 {
        @Override
        public String getName(){
            return "ubuntu-18.10";
        }
    },

}
