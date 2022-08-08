# Course Alura - Devops: Jenkins Pipeline As Code: All you need to know A - Z
## Virtual machina nao atualiza
Error: Failed to download metadata for repo 'AppStream'

[root@localhost ~]# cd /etc/yum.repos.d/
[root@localhost yum.repos.d]# sed -i 's/mirrorlist/#mirrorlist/g' /etc/yum.repos.d/CentOS-*
[root@localhost yum.repos.d]# sed -i 's|#baseurl=http://mirror.centos.org|baseurl=http://vault.centos.org|g' /etc/yum.repos.d/CentOS-*gem

## Erro Git: Could not resolve host github.com

git config --global --unset http.proxy
git config --global --unset https.proxy