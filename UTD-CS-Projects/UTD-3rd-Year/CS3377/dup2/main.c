#include <unistd.h>
#include <errno.h>

int mydup_rec(int od,int nd){
  int fd=dup(od);
  if(fd==nd)
    return nd;
  else{
    int fd0=mydup_rec(od,nd);
    close(fd);
    return fd0;
  }
}

int mydup2(int oldd,int newd){
  int fd,fd0,maxd=sysconf(_SC_OPEN_MAX);

  if(oldd<0 || oldd>=maxd || /* check the range of descriptors */
     newd<0 || newd>=maxd || /* and if oldd is open*/
     (lseek(oldd,0,SEEK_CUR)==-1 && errno==EBADF)){
    errno=EBADF;
    return -1;
  }

  if(oldd==newd) /* if they are the same don't do anything */
    return oldd;

  close(newd);   /* close newd if open */

  return mydup_rec(oldd,newd);
}
