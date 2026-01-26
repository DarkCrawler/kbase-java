SRC_DIR='../proto'
DST_DIR='../generated'
PROTOC_JAVA_PLUGIN='/Users/sg0220142/apps/protoc/protoc-gen-grpc-java'

protoc \
  --plugin=protoc-gen-grpc-java=$PROTOC_JAVA_PLUGIN \
  -I=$SRC_DIR \
  --java_out=$DST_DIR \
  --grpc-java_out=$DST_DIR \
  $SRC_DIR/HelloService.proto