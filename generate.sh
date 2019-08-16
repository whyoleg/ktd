#!/usr/bin/env bash
#sudo apt install gcc openssl gperf cmake zlib1g-dev ccache libssl-dev -y
readonly DATA=$PWD/generated/td/lib/cmake/Td

cd td || exit
mkdir -p jnibuild
cd jnibuild || exit
cmake -DCMAKE_BUILD_TYPE=Release -DTD_ENABLE_JNI=ON -DCMAKE_INSTALL_PREFIX:PATH=../../generated/td ..
cmake --build . --target install

cd ../../generated || exit
mkdir -p build
cd build || exit
cmake -DTd_DIR=$DATA -DCMAKE_INSTALL_PREFIX:PATH=.. ..
cmake --build . --target install

cd ../bin || exit
cp libtdjni.so ../../library/src/main/libs
