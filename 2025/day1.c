#include <stdio.h>
#include <stdlib.h>

// remove l or r
char *removeLR(char s[]) {
  int i;
  char *s2;
  s2 = (char *)malloc(20);

  for (i = 1; s[i] != '\0'; i++) {
    s2[i - 1] = s[i];
  }
  return (char *)s2;
}

int main() {
  FILE *fptr = fopen("input.txt", "r");

  char rotation[8];
  int curr = 50;
  while (fscanf(fptr, "%s", rotation) != EOF) {
    char *s2;
    s2 = removeLR(rotation);
    printf("%c|", rotation[0]);
    printf("%s\n", s2);
    free(s2);
  }
  fclose(fptr);

  return 0;
}
